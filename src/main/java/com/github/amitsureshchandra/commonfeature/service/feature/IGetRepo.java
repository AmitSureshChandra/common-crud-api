package com.github.amitsureshchandra.commonfeature.service.feature;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGetRepo<T, T_ID> {
    JpaRepository<T, T_ID> getRepo();
}
