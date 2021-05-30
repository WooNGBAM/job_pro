package com.example.job_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;


@Getter
@Setter
@Embeddable
public class Holiday {
    private LocalDate holidays;

}
