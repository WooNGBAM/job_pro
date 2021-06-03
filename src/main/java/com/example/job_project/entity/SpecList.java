package com.example.job_project.entity;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

//점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, level, 조회 일자 기준 영업시간 3일치(오픈시간, 마감시간, 영업상태, 요일))
@Getter
@Setter
public class SpecList {
    private int id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private int level;
    private List<Business> businessDays;

}
