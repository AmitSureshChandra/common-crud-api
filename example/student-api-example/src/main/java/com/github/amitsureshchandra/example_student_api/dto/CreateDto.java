package com.github.amitsureshchandra.example_student_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDto {
    private String name;
    private String email;
}
