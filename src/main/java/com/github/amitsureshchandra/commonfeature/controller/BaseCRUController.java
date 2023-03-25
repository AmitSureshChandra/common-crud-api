package com.github.amitsureshchandra.commonfeature.controller;

import com.github.amitsureshchandra.commonfeature.service.BaseCRUService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseCRUController<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> {
    BaseCRUService<T, T_ID, T_CREATE_DTO, T_UPDATE_DTO> getCRUService();

    @GetMapping("/{id}")
    default ResponseEntity<T> getById(@PathVariable T_ID id) {
        return new ResponseEntity<>(getCRUService().findById(id), HttpStatus.OK);
    }

    @GetMapping
    default ResponseEntity<List<T>> getAll() {
        return new ResponseEntity<>(getCRUService().findAll(), HttpStatus.OK);
    }

    @PostMapping
    default ResponseEntity<T> create(@RequestBody T_CREATE_DTO createDto){
        return new ResponseEntity<>(getCRUService().create(createDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    default ResponseEntity<T> getById(@PathVariable T_ID id, @RequestBody T_UPDATE_DTO updateDto) {
        return new ResponseEntity<>(getCRUService().update(id, updateDto), HttpStatus.OK);
    }
}
