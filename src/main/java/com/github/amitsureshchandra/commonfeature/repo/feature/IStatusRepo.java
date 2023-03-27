package com.github.amitsureshchandra.commonfeature.repo.feature;

import com.github.amitsureshchandra.commonfeature.entity.base.BaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStatusRepo <T extends BaseStatus, TID> extends JpaRepository<T, TID> {
    @Query("SELECT t FROM #{#entityName} t WHERE t.status != com.github.amitsureshchandra.commonfeature.enums.StatusEnum.ARCHIVE")
    List<T> findAll();
}
