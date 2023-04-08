package com.github.amitsureshchandra.userpostexample.controller;

import com.github.amitsureshchandra.common_crud_api.controller.feature.IBaseCRUController;
import com.github.amitsureshchandra.common_crud_api.service.feature.IBaseCRUService;
import com.github.amitsureshchandra.userpostexample.dto.user.UserCreateDto;
import com.github.amitsureshchandra.userpostexample.dto.user.UserUpdateDto;
import com.github.amitsureshchandra.userpostexample.entity.User;
import com.github.amitsureshchandra.userpostexample.projection.UserPostListPrj;
import com.github.amitsureshchandra.userpostexample.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements IBaseCRUController<User, Long, UserCreateDto, UserUpdateDto> {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("{uId}/posts")
    List<UserPostListPrj> posts(@PathVariable Long uId) {
        return userService.getPosts(uId);
    }

    @Override
    public IBaseCRUService<User, Long, UserCreateDto, UserUpdateDto> getCRUService() {
        return userService;
    }
}
