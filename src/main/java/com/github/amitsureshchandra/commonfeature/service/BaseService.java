package com.github.amitsureshchandra.commonfeature.service;

import com.github.amitsureshchandra.commonfeature.service.feature.IGetAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class BaseService implements IGetAppContext {
    public ApplicationContext applicationContext;

    @Override
    public ApplicationContext getAppContext() {
        return applicationContext;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
