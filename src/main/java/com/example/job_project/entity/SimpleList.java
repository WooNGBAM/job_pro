package com.example.job_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class SimpleList {
    private String name;
    private String description;
    private int level;
    private String businessStatus;

}
