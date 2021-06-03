package com.example.job_project.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @ElementCollection
    private List<Business> businessTimes = new ArrayList<Business>();

    @ElementCollection
    @Temporal(TemporalType.DATE)
    private List<Date> holidays = new ArrayList<Date>();

}



