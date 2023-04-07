package com.github.amitsureshchandra.common_crud_api.service.feature;

import com.github.amitsureshchandra.common_crud_api.entity.base.BaseStatus;
import com.github.amitsureshchandra.common_crud_api.enums.StatusEnum;
import com.github.amitsureshchandra.common_crud_api.exception.ValidationException;

public interface IBaseStatusService<T extends BaseStatus, T_ID> extends IGetRepo<T, T_ID> {
    default String updateStatus(T_ID id , StatusEnum status) {
        T entity = getRepo().findById(id).orElseThrow(() -> new ValidationException("not found"));

        // no action taken if already archived
        if(entity.getStatus().equals(StatusEnum.ARCHIVE)) throw new ValidationException("already archived");

        entity.setStatus(status);
        getRepo().save(entity);

        return "OK";
    }
}
