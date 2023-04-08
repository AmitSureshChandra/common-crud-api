package com.github.amitsureshchandra.userpostexample.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateDto {

    @Email
    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String mobile;
}
