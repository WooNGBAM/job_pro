package com.example.job_project.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String owner;
    private String description;
    private int level;
    private String address;
    private String phone;
    @OneToMany
    private ArrayList<Business> BusinessTimes = new ArrayList<Business>();







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
@Entity
class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    private int marketId;
    private String day;
    private Time open;
    private Time close;
    private boolean holiday;
    private  String businessStatus;

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

    public int getMarketId() {
        return marketId;
    }
}
