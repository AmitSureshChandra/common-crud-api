package com.github.amitsureshchandra.commonfeature.controller;

import com.github.amitsureshchandra.commonfeature.entity.Student;
import com.github.amitsureshchandra.commonfeature.service.BaseCRUService;
import com.github.amitsureshchandra.commonfeature.service.BaseStatusService;
import com.github.amitsureshchandra.commonfeature.service.RepoRegisterService;
import com.github.amitsureshchandra.commonfeature.service.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController implements BaseStatusController<Long>, BaseCRUController<Student, Long, Student, Student> {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public BaseStatusService<Long> getStatusService() {
        return studentService;
    }

    @Override
    public BaseCRUService<Student, Long, Student, Student > getCRUService() {
        return studentService;
    }

}
