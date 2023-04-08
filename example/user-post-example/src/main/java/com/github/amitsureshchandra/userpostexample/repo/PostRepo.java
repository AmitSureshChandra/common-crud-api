package com.github.amitsureshchandra.userpostexample.repo;

import com.github.amitsureshchandra.userpostexample.entity.Post;
import com.github.amitsureshchandra.userpostexample.projection.UserPostListPrj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdNot(String title, Long id);

    @Query("SELECT p.title as title, p.description as description FROM Post p WHERE p.user.id = :uid")
    List<UserPostListPrj> findByUserId(Long uid);
}
