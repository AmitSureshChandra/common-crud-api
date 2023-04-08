package com.github.amitsureshchandra.example_student_api.repo;

import com.github.amitsureshchandra.common_crud_api.repo.feature.IStatusRepo;
import com.github.amitsureshchandra.example_student_api.entity.Student;
import org.springframework.stereotype.Repository;

public interface IStudentRepo extends IStatusRepo<Student, Long> {
    boolean existsByNameOrEmail(String name, String email);
    boolean existsByNameOrEmailAndIdNot(String name, String email, Long id);
}
