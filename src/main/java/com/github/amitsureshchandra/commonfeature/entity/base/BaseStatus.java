package com.github.amitsureshchandra.commonfeature.entity.base;

import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseStatus {
    private StatusEnum status;
}
