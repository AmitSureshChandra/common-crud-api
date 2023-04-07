package com.github.amitsureshchandra.common_crud_api.entity.base;

import com.github.amitsureshchandra.common_crud_api.enums.StatusEnum;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseStatus {
    private StatusEnum status;
}
