package com.github.amitsureshchandra.commonfeature.controller.feature;

import com.github.amitsureshchandra.commonfeature.entity.base.BaseStatus;
import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface IBaseStatusController<T extends BaseStatus, T_ID> {
    IBaseStatusService<T, T_ID> getStatusService();

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
