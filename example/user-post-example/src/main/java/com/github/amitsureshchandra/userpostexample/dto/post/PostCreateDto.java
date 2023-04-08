package com.github.amitsureshchandra.userpostexample.dto.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor
public class PostCreateDto {
    @NotNull
    private Long userId;

    @NotNull @NotBlank
    private String title;

    @NotNull @NotBlank
    private String description;
}
