package com.github.amitsureshchandra.example_student_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "com.github.amitsureshchandra.common_crud_api",
        "com.github.amitsureshchandra.example_student_api"
})
public class StudentCRUDExampleApp {

    public static void main(String[] args) {
        SpringApplication.run(StudentCRUDExampleApp.class, args);
    }

}
