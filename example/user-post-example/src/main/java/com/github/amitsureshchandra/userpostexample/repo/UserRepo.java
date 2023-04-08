package com.github.amitsureshchandra.userpostexample.repo;

import com.github.amitsureshchandra.userpostexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
