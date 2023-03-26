package com.github.amitsureshchandra.commonfeature.service;

import com.github.amitsureshchandra.commonfeature.repo.StuRepo;
import com.github.amitsureshchandra.commonfeature.entity.Student;
import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements BaseStatusService<Long>, BaseCRUService<Student, Long, Student, Student> {

    final RepoRegisterService repoRegisterService;

    final ApplicationContext context;

    final StuRepo stuRepo;

    public StudentService(RepoRegisterService repoRegisterService, StuRepo stuRepo, ApplicationContext context) {
        this.repoRegisterService = repoRegisterService;
        this.stuRepo = stuRepo;
        this.context = context;
    }

    @Override
    public JpaRepository<Student, Long> getRepo() {
        return repoRegisterService.getRepo("stuRepo");
    }

    @Override
    public Student findById(Long aLong) {
        return stuRepo.findById(aLong).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Student> findAll() {
        return stuRepo.findAll();
    }

    @Override
    public Student create(Student entity) {
        entity.setStatus(StatusEnum.ENABLE);
        return stuRepo.save(entity);
    }

    @Override
    public Student update(Long aLong, Student stuDto) {
        Student  stu = findById(aLong);
        stu.setName(stuDto.getName());
        stu.setEmail(stuDto.getEmail());
        return stuRepo.save(stu);
    }

    @Override
    public String updateStatus(Long aLong, StatusEnum status) {
        Student student = findById(aLong);
        student.setStatus(status);
        stuRepo.save(student);
        return "OK";
    }
}
