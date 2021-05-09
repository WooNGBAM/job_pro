package com.example.job_project.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Embeddable
public class Business {
    private int number;
    private String day;
    private Time open;
    private Time close;
    private boolean holiday;
    private  String businessStatus;

    public void addDay(String day){
        this.day = day;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getOpen() {
        return open;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public Time getClose() {
        return close;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }


}
