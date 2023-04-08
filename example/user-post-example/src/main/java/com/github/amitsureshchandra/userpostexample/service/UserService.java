package com.github.amitsureshchandra.userpostexample.service;

import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseCRUService;
import com.github.amitsureshchandra.userpostexample.dto.user.UserCreateDto;
import com.github.amitsureshchandra.userpostexample.dto.user.UserUpdateDto;
import com.github.amitsureshchandra.userpostexample.entity.User;
import com.github.amitsureshchandra.userpostexample.projection.UserPostListPrj;
import com.github.amitsureshchandra.userpostexample.repo.PostRepo;
import com.github.amitsureshchandra.userpostexample.repo.UserRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IBaseCRUService<User, Long, UserCreateDto, UserUpdateDto> {

    final ApplicationContext applicationContext;
    final UserRepo userRepo;
    final PostRepo postRepo;

    public UserService(ApplicationContext applicationContext, UserRepo userRepo, PostRepo postRepo) {
        this.applicationContext = applicationContext;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @Override
    public ApplicationContext getAppContext() {
        return applicationContext;
    }

    @Override
    public JpaRepository<User, Long> getRepo() {
        return userRepo;
    }

    public List<UserPostListPrj> getPosts(Long uId) {
        return postRepo.findByUserId(uId);
    }
}
