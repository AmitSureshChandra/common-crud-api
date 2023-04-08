package com.github.amitsureshchandra.userpostexample.controller;

import com.github.amitsureshchandra.common_crud_api.controller.feature.IBaseCRUDController;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseCRUDService;
import com.github.amitsureshchandra.userpostexample.dto.post.PostCreateDto;
import com.github.amitsureshchandra.userpostexample.dto.post.PostUpdateDto;
import com.github.amitsureshchandra.userpostexample.entity.Post;
import com.github.amitsureshchandra.userpostexample.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController implements IBaseCRUDController<Post, Long, PostCreateDto, PostUpdateDto> {

    final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Override
    public IBaseCRUDService<Post, Long, PostCreateDto, PostUpdateDto> getCRUDService() {
        return postService;
    }
}
