package com.example.job_project.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Embeddable
public class Business {
    private String day;//요일임
    private LocalTime open;
    private LocalTime close;
    private String businessStatus;

}

