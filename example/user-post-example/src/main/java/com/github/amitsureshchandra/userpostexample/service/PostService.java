package com.github.amitsureshchandra.userpostexample.service;

import com.github.amitsureshchandra.common_crud_api.exception.ValidationException;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseCRUDService;
import com.github.amitsureshchandra.userpostexample.dto.post.PostCreateDto;
import com.github.amitsureshchandra.userpostexample.dto.post.PostUpdateDto;
import com.github.amitsureshchandra.userpostexample.entity.Post;
import com.github.amitsureshchandra.userpostexample.entity.User;
import com.github.amitsureshchandra.userpostexample.repo.PostRepo;
import com.github.amitsureshchandra.userpostexample.repo.UserRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IBaseCRUDService<Post, Long, PostCreateDto, PostUpdateDto> {

    final ApplicationContext applicationContext;
    final PostRepo postRepo;

    final UserRepo userRepo;
    final UserService userService;

    public PostService(ApplicationContext applicationContext, PostRepo postRepo, UserRepo userRepo, UserService userService) {
        this.applicationContext = applicationContext;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @Override
    public void beforeUpdate(Post entity, PostUpdateDto postUpdateDto) {
        if(postRepo.existsByTitleAndIdNot(postUpdateDto.getTitle(), entity.getId())) throw  new ValidationException("title already exists");    }

    @Override
    public void validateOnCreate(PostCreateDto postCreateDto) {
        if(postRepo.existsByTitle(postCreateDto.getTitle())) throw  new ValidationException("title already exists");
    }

    @Override
    public void beforeCreate(Post entity, PostCreateDto postCreateDto) {
        User user = userService.findById(postCreateDto.getUserId());
        entity.setUser(user);
    }

    @Override
    public ApplicationContext getAppContext() {
        return applicationContext;
    }

    @Override
    public JpaRepository<Post, Long> getRepo() {
        return postRepo;
    }
}
