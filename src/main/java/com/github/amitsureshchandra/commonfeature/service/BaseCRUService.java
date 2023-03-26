package com.github.amitsureshchandra.commonfeature.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> {

    JpaRepository<T, T_ID> getRepo();


    default T findById(T_ID id){
        
    }

    default List<T> findAll() {
        return getRepo().findAll();
    }

    T create(T_CREATE_DTO entity);

    T update(T_ID id, T_UPDATE_DTO updateDto);
}
