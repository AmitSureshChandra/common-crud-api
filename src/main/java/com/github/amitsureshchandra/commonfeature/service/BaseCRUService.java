package com.github.amitsureshchandra.commonfeature.service;

import java.util.List;

public interface BaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> {
    T findById(T_ID id);

    List<T> findAll();

    T create(T_CREATE_DTO entity);

    T update(T_ID id, T_UPDATE_DTO updateDto);
}
