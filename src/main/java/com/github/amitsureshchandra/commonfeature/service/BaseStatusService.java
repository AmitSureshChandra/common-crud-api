package com.github.amitsureshchandra.commonfeature.service;

import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;

public interface BaseStatusService<T_ID> {
    String updateStatus(T_ID id , StatusEnum disable);
}
