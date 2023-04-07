package com.github.amitsureshchandra.common_crud_api.service.feature;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGetRepo<T, T_ID> {
    JpaRepository<T, T_ID> getRepo();
}
