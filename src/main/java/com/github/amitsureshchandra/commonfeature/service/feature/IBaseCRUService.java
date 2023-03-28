package com.github.amitsureshchandra.commonfeature.service.feature;

import com.github.amitsureshchandra.commonfeature.exception.ValidationException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public interface IBaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> extends IGetRepo<T, T_ID>, IGetAppContext {

    Logger logger = LoggerFactory.getLogger(IBaseCRUService.class);
    default T findById(T_ID id){
        return getRepo().findById(id).orElseThrow(() -> new ValidationException("not found"));
    }

    default List<T> findAll() {
        return getRepo().findAll();
    }

    default void beforeCreate(T entity, T_CREATE_DTO dto) {
        return ;
    }

    default T create(T_CREATE_DTO dto) {
        Type type = getEntityType();
        T entity = ((ModelMapper)(getAppContext().getBean("modelMapper"))).map(dto, type);
        beforeCreate(entity, dto);
        return getRepo().save(entity);
    }

    default Type getEntityType() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]);
    }

    default Type getUpdateEntityType() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[3]);
    }

    default T update(T_ID id, T_UPDATE_DTO updateDto) {
        T entity = findById(id);
        updateFields(entity, updateDto);
        beforeUpdate(entity, updateDto);
        return getRepo().save(entity);
    }

    default void updateFields(T entity, T_UPDATE_DTO updateDto) {
        System.out.println("!! started !!");
        Map<String, Field> updateFields = new HashMap<>();

        for (Field f: updateDto.getClass().getDeclaredFields()){
            updateFields.put(f.getName(), f);
        }

//        Set<String> entityFields = Arrays.stream(
//                        entity.getClass().getDeclaredFields()
//                )
//                .map(Field::getName)
//                .collect(Collectors.toSet());

        System.out.println("update fields : " + updateFields);
//        System.out.println("entity fields : " + entityFields);

        for (Field field: entity.getClass().getDeclaredFields()) {
            System.out.println("field : " + field);
            if(!updateFields.containsKey(field.getName())) continue;
            Field updateField = updateFields.get(field.getName());
            updateField.setAccessible(true);
            field.setAccessible(true);

            try {
                field.set(entity, updateField.get(updateDto));
                System.out.println(updateField.getName() + " is updated");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

//        for (String entityField :
//                entityFields) {
//            System.out.println("entityFields : " + entityField);
//
//            if(!updateFields.contains(entityField)) {
//                System.out.println(entityField + " not matched");
//                continue;
//            }
//            try {
//                System.out.println("updating field " + entityField);
//
//                entity.getClass().getDeclaredField(entityField).setAccessible(true);
//                updateDto.getClass().getDeclaredField(entityField).setAccessible(true);
//
//                System.out.println("data : " + updateDto.getClass().getDeclaredField(entityField).get(updateDto));
//
//                entity.getClass().getDeclaredField(entityField).set(entity, updateDto.getClass().getDeclaredField(entityField).get(updateDto));
//            } catch (IllegalAccessException | NoSuchFieldException e) {
//                logger.error(e.getMessage());
//                logger.error("failed to update for " + getEntityType().getTypeName() + " on dto " + getUpdateEntityType());
//                return;
//            }
//        }

        System.out.println("!! ended !!");
    }

    default void beforeUpdate(T entity, T_UPDATE_DTO updateDto){
        return;
    }
}
