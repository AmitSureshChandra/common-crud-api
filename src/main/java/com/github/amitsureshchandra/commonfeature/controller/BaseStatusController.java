package com.github.amitsureshchandra.commonfeature.controller;

import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import com.github.amitsureshchandra.commonfeature.service.BaseStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface BaseStatusController<T_ID> {
    BaseStatusService<T_ID> getStatusService();

    @PostMapping("/{id}/status/disable")
    default ResponseEntity<String> disable(@PathVariable T_ID id) {
        return new ResponseEntity<>(getStatusService().updateStatus(id, StatusEnum.DISABLE), HttpStatus.OK);
    }

    @PostMapping("/{id}/status/enable")
    default ResponseEntity<String> enable(@PathVariable T_ID id) {
        return new ResponseEntity<>(getStatusService().updateStatus(id, StatusEnum.ENABLE), HttpStatus.OK);
    }

    @PostMapping("/{id}/status/archive")
    default ResponseEntity<String> archive(@PathVariable T_ID id) {
        return new ResponseEntity<>(getStatusService().updateStatus(id, StatusEnum.ARCHIVE), HttpStatus.OK);
    }
}
