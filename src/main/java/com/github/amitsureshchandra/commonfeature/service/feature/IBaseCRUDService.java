package com.github.amitsureshchandra.commonfeature.service.feature;

public interface IBaseCRUDService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> extends IBaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO>{
    default void deleteById(T_ID id){
        getRepo().deleteById(id);
    }
}
