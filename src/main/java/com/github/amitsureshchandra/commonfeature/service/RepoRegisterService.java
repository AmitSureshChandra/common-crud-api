package com.github.amitsureshchandra.commonfeature.service;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class RepoRegisterService {
    final ApplicationContext context;
    private Map<String, JpaRepository> map = new HashMap<>();

    public JpaRepository getRepo(String key){
        return map.get(key);
    }

    public RepoRegisterService(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    void init(){
        context.getBeansOfType(JpaRepository.class).forEach((s, jpaRepository) -> {
            System.out.println(s + " registered");
            map.put(s, jpaRepository);
        });
    }
}
