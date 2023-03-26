package com.github.amitsureshchandra.commonfeature.service;

import com.github.amitsureshchandra.commonfeature.resolver.IRepoNameResolver;
import com.github.amitsureshchandra.commonfeature.repo.IStudentRepo;
import com.github.amitsureshchandra.commonfeature.entity.Student;
import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseCRUService;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseStatusService;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService implements IBaseStatusService<Student, Long>, IBaseCRUService<Student, Long, Student, Student>, IRepoNameResolver {

    final ContextUtilService repoRegisterService;

    final ApplicationContext context;

    final IStudentRepo stuRepo;

    public StudentService(ContextUtilService repoRegisterService, IStudentRepo stuRepo, ApplicationContext context) {
        this.repoRegisterService = repoRegisterService;
        this.stuRepo = stuRepo;
        this.context = context;
    }

    @Override
    public JpaRepository<Student, Long> getRepo() {
        return repoRegisterService.getRepo(getRepoName());
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
    public String getRepoName() {
        return "student_repo";
    }
}
