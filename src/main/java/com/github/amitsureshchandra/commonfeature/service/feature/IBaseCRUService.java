package com.github.amitsureshchandra.commonfeature.service.feature;

import com.github.amitsureshchandra.commonfeature.exception.ValidationException;
import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public interface IBaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> extends IGetRepo<T, T_ID>, IGetAppContext {
    default T findById(T_ID id){
        return getRepo().findById(id).orElseThrow(() -> new ValidationException("not found"));
    }

    default List<T> findAll() {
        return getRepo().findAll();
    }

    default T beforeCreate(T entity, T_CREATE_DTO dto) {
        return entity;
    }

    default T create(T_CREATE_DTO dto) {
        Type type = ((Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]);
        T entity = ((ModelMapper)(getAppContext().getBean("modelMapper"))).map(dto, type);
        entity = beforeCreate(entity, dto);
        return getRepo().save(entity);
    }

    default T update(T_ID id, T_UPDATE_DTO updateDto) {
        T entity = findById(id);
        entity = beforeUpdate(entity, updateDto);
        return getRepo().save(entity);
    }

    default T beforeUpdate(T entity, T_UPDATE_DTO updateDto){
        return entity;
    }
}
