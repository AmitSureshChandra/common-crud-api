package com.github.amitsureshchandra.common_crud_api.controller.feature;

import com.github.amitsureshchandra.common_crud_api.dto.ResponseMessage;
import com.github.amitsureshchandra.common_crud_api.entity.base.BaseStatus;
import com.github.amitsureshchandra.common_crud_api.enums.StatusEnum;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface IBaseStatusController<T extends BaseStatus, T_ID> {
    IBaseStatusService<T, T_ID> getStatusService();

    @PostMapping("/{id}/status/disable")
    default ResponseEntity<ResponseMessage> disable(@PathVariable T_ID id) {
        return new ResponseEntity<>(new ResponseMessage(getStatusService().updateStatus(id, StatusEnum.DISABLE)), HttpStatus.OK);
    }

    @PostMapping("/{id}/status/enable")
    default ResponseEntity<ResponseMessage> enable(@PathVariable T_ID id) {
        return new ResponseEntity<>(new ResponseMessage(getStatusService().updateStatus(id, StatusEnum.ENABLE)), HttpStatus.OK);
    }

    @PostMapping("/{id}/status/archive")
    default ResponseEntity<ResponseMessage> archive(@PathVariable T_ID id) {
        return new ResponseEntity<>(new ResponseMessage(getStatusService().updateStatus(id, StatusEnum.ARCHIVE)), HttpStatus.OK);
    }
}
