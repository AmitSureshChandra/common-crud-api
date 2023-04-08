package com.github.amitsureshchandra.userpostexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {
        "com.github.amitsureshchandra.common_crud_api",
        "com.github.amitsureshchandra.userpostexample"
})
public class UserPostExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserPostExampleApplication.class, args);
    }

}
