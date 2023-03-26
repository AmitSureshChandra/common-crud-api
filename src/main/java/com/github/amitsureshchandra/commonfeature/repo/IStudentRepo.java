package com.github.amitsureshchandra.commonfeature.repo;

import com.github.amitsureshchandra.commonfeature.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("student_repo")
public interface IStudentRepo extends JpaRepository<Student, Long> {
}
