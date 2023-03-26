package com.github.amitsureshchandra.commonfeature.entity;

import com.github.amitsureshchandra.commonfeature.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends BaseStatus implements RepoNameResolver{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @Override
    public String getRepoName() {
        return "stuRepo";
    }
}
