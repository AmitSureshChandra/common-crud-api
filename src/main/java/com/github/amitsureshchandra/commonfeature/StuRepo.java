package com.github.amitsureshchandra.commonfeature;

import com.github.amitsureshchandra.commonfeature.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepo extends JpaRepository<Student, Long> {
}
