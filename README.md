# common-feature-controller
Implementing common feature controller

## sample for controller

```java
package com.github.amitsureshchandra.commonfeatureapplication.controller;

import com.github.amitsureshchandra.commonfeature.controller.feature.IBaseCRUController;
import com.github.amitsureshchandra.commonfeature.controller.feature.IBaseStatusController;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseCRUService;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseStatusService;
import com.github.amitsureshchandra.commonfeatureapplication.entity.Student;
import com.github.amitsureshchandra.commonfeatureapplication.service.StudentService;
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
```

## sample for entity

```java
package com.github.amitsureshchandra.commonfeatureapplication.entity;

import com.github.amitsureshchandra.commonfeature.entity.base.BaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends BaseStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
```

## sample for servie

```java
package com.github.amitsureshchandra.commonfeatureapplication.service;

import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import com.github.amitsureshchandra.commonfeature.resolver.IRepoNameResolver;
import com.github.amitsureshchandra.commonfeature.service.BaseService;
import com.github.amitsureshchandra.commonfeature.service.ContextUtilService;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseCRUService;
import com.github.amitsureshchandra.commonfeature.service.feature.IBaseStatusService;
import com.github.amitsureshchandra.commonfeatureapplication.entity.Student;
import com.github.amitsureshchandra.commonfeatureapplication.repo.IStudentRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService implements IBaseStatusService<Student, Long>, IBaseCRUService<Student, Long, Student, Student>, IRepoNameResolver {
    final ContextUtilService repoRegisterService;

    final IStudentRepo stuRepo;

    public StudentService(ContextUtilService repoRegisterService, IStudentRepo stuRepo) {
        this.repoRegisterService = repoRegisterService;
        this.stuRepo = stuRepo;
    }

    @Override
    public JpaRepository<Student, Long> getRepo() {
        return repoRegisterService.getRepo(getRepoName());
    }

    @Override
    public Student beforeCreate(Student entity, Student createDto) {
        System.out.println("we can modify before create");
        entity.setStatus(StatusEnum.ENABLE);
        return entity;
    }

    @Override
    public Student beforeUpdate(Student student, Student stuDto) {
        System.out.println("we can modify before update");
        student.setName(stuDto.getName());
        student.setEmail(stuDto.getEmail());
        return student;
    }

    @Override
    public String getRepoName() {
        return "student_repo";
    }
}
```

## sample for repo

```java
package com.github.amitsureshchandra.commonfeatureapplication.repo;

import com.github.amitsureshchandra.commonfeatureapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("student_repo")
public interface IStudentRepo extends IStatusRepo<Student, Long> {
}
```
