package com.github.amitsureshchandra.commonfeature.controller.feature;

import com.github.amitsureshchandra.commonfeature.service.feature.IBaseCRUDService;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseCRUService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IBaseCRUDController<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO>
        extends IBaseCRUController<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> {
    IBaseCRUDService<T,T_ID, T_CREATE_DTO, T_UPDATE_DTO> getCRUDService();
    default IBaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> getCRUService() {
        return getCRUDService();
    }
    @DeleteMapping("/{id}")
    default ResponseEntity<Void> deleteById(@PathVariable T_ID id) {
        getCRUDService().deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
