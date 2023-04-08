package com.github.amitsureshchandra.example_student_api.controller;

import com.github.amitsureshchandra.common_crud_api.controller.feature.IBaseCRUDController;
import com.github.amitsureshchandra.common_crud_api.controller.feature.IBaseStatusController;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseCRUDService;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseStatusService;
import com.github.amitsureshchandra.example_student_api.dto.CreateDto;
import com.github.amitsureshchandra.example_student_api.dto.UpdateDto;
import com.github.amitsureshchandra.example_student_api.entity.Student;
import com.github.amitsureshchandra.example_student_api.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController implements IBaseCRUDController<Student, Long, CreateDto, UpdateDto>, IBaseStatusController<Student, Long> {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public IBaseCRUDService<Student, Long, CreateDto, UpdateDto> getCRUDService() {
        return studentService;
    }

    @Override
    public IBaseStatusService<Student, Long> getStatusService() {
        return studentService;
    }
}
