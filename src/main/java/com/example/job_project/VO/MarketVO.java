package com.example.job_project.VO;

import com.example.job_project.entity.Business;
import com.example.job_project.entity.SimpleList;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class MarketVO {
    @SerializedName("ID")
    private int id;

    @SerializedName("NAME")
    private String name;

    @SerializedName("OWNER")
    private String owner;

    @SerializedName("DESCRIPTION")
    private String description;

    @SerializedName("LEVEL")
    private int level;

    @SerializedName("ADDRESS")
    private String address;

    @SerializedName("PHONE")
    private String phone;

    @SerializedName("BUSINESS TIMES")
    private List<Business> businessTimes = new ArrayList<Business>();
    @SerializedName("HOLIDAYS")
    private List<Date> holidays = new ArrayList<Date>();
    @SerializedName("LIST")
    private List<SimpleList> list = new ArrayList<SimpleList>();
}
