package com.github.amitsureshchandra.commonfeature.service;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ContextUtilService extends BaseService {
    final ApplicationContext context;

    public JpaRepository getRepo(String key){
        return (JpaRepository) context.getBean(key);
    }

    public ContextUtilService(ApplicationContext context) {
        this.context = context;
    }
}
