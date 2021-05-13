package com.example.job_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
@Embeddable
public class Holiday {
    private Date holidays;

}
