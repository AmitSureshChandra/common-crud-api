package com.github.amitsureshchandra.common_crud_api.service.feature;

import com.github.amitsureshchandra.common_crud_api.exception.ValidationException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> extends IGetRepo<T, T_ID>, IGetAppContext {

    Logger logger = LoggerFactory.getLogger(IBaseCRUService.class);
    default T findById(T_ID id){
        return getRepo().findById(id).orElseThrow(() -> new ValidationException("not found"));
    }

    default List<T> findAll() {
        return getRepo().findAll();
    }

    default void beforeCreate(T entity, T_CREATE_DTO dto) {
    }
    default T create(T_CREATE_DTO dto) {
        validateOnCreate(dto);
        Type type = getEntityType();
        ModelMapper modelMapper = ((ModelMapper)(getAppContext().getBean("modelMapper")));
        T entity = modelMapper.map(dto, type);
        beforeCreate(entity, dto);
        return getRepo().save(entity);
    }

    default void validateOnCreate(T_CREATE_DTO dto) {}

    default Type getEntityType() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]);
    }

    default Type getUpdateEntityType() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[3]);
    }

    default T update(T_ID id, T_UPDATE_DTO updateDto) {
        T entity = findById(id);
        validateOnUpdate(entity, updateDto);
        updateFields(entity, updateDto);
        beforeUpdate(entity, updateDto);
        return getRepo().save(entity);
    }

    default void validateOnUpdate(T id, T_UPDATE_DTO updateDto){}

    default void updateFields(T entity, T_UPDATE_DTO updateDto) {
        Map<String, Field> updateFields = new HashMap<>();

        for (Field f: updateDto.getClass().getDeclaredFields()){
            updateFields.put(f.getName(), f);
        }

        for (Field field: entity.getClass().getDeclaredFields()) {
            if(!updateFields.containsKey(field.getName())) continue;
            Field updateField = updateFields.get(field.getName());
            updateField.setAccessible(true);
            field.setAccessible(true);

            try {
                field.set(entity, updateField.get(updateDto));
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage());
            }
        }
    }

    default void beforeUpdate(T entity, T_UPDATE_DTO updateDto){
    }
}
