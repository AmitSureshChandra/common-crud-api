package com.github.amitsureshchandra.commonfeature.controller;

import com.github.amitsureshchandra.commonfeature.controller.feature.IBaseCRUController;
import com.github.amitsureshchandra.commonfeature.controller.feature.IBaseStatusController;
import com.github.amitsureshchandra.commonfeature.entity.Student;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseCRUService;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseStatusService;
import com.github.amitsureshchandra.commonfeature.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController implements IBaseStatusController<Student, Long>, IBaseCRUController<Student, Long, Student, Student> {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public IBaseStatusService<Student, Long> getStatusService() {
        return studentService;
    }

    @Override
    public IBaseCRUService<Student, Long, Student, Student > getCRUService() {
        return studentService;
    }

}
