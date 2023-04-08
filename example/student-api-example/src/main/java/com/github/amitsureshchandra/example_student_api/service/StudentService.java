package com.github.amitsureshchandra.example_student_api.service;

import com.github.amitsureshchandra.common_crud_api.enums.StatusEnum;
import com.github.amitsureshchandra.common_crud_api.exception.ValidationException;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseCRUDService;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseStatusService;
import com.github.amitsureshchandra.example_student_api.dto.CreateDto;
import com.github.amitsureshchandra.example_student_api.dto.UpdateDto;
import com.github.amitsureshchandra.example_student_api.entity.Student;
import com.github.amitsureshchandra.example_student_api.repo.IStudentRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IBaseCRUDService<Student, Long, CreateDto, UpdateDto>, IBaseStatusService<Student, Long> {
    final IStudentRepo stuRepo;
    final ApplicationContext appContext;

    public StudentService(IStudentRepo stuRepo, ApplicationContext appContext) {
        this.stuRepo = stuRepo;
        this.appContext = appContext;
    }

    @Override
    public JpaRepository<Student, Long> getRepo() {
        return stuRepo;
    }

    @Override
    public void validateOnCreate(CreateDto createDto) {
        // check for unique name & email
        if(stuRepo.existsByNameOrEmail(createDto.getName(), createDto.getEmail())) throw  new ValidationException("already exists");
    }

    @Override
    public void beforeUpdate(Student entity, UpdateDto updateDto) {
        // check for unique name & email
        if(stuRepo.existsByNameOrEmailAndIdNot(updateDto.getName(), updateDto.getEmail(), entity.getId())) throw  new ValidationException("already exists");
    }

    @Override
    public void beforeCreate(Student entity, CreateDto createDto) {
        entity.setStatus(StatusEnum.ENABLE);
    }

    @Override
    public ApplicationContext getAppContext() {
        return appContext;
    }
}
