package com.github.amitsureshchandra.userpostexample.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class UserCreateDto {

    @NotNull @NotBlank
    private String username;

    @NotNull @NotBlank @Email
    private String email;

    @NotNull @NotBlank
    private String mobile;
}
