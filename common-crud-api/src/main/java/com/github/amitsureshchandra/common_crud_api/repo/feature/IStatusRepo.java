package com.github.amitsureshchandra.common_crud_api.repo.feature;

import com.github.amitsureshchandra.common_crud_api.entity.base.BaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStatusRepo <T extends BaseStatus, TID> extends JpaRepository<T, TID> {
    @Query("SELECT t FROM #{#entityName} t WHERE t.status != com.github.amitsureshchandra.common_crud_api.enums.StatusEnum.ARCHIVE")
    List<T> findAll();
}
