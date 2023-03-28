package com.github.amitsureshchandra.commonfeature.config;

import com.github.amitsureshchandra.commonfeature.convertor.UUIDToLongConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new UUIDToLongConverter());
        return modelMapper;
    }
}
