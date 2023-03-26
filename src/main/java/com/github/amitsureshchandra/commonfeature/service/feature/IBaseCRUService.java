package com.github.amitsureshchandra.commonfeature.service.feature;

import com.github.amitsureshchandra.commonfeature.exception.ValidationException;

import java.util.List;

public interface IBaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> extends IGetRepo<T, T_ID> {
    default T findById(T_ID id){
        return getRepo().findById(id).orElseThrow(() -> new ValidationException("not found"));
    }

    default List<T> findAll() {
        return getRepo().findAll();
    }

    T create(T_CREATE_DTO entity);

    T update(T_ID id, T_UPDATE_DTO updateDto);
}
