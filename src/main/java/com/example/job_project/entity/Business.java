package com.example.job_project.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Embeddable
public class Business {
    private String day;//요일임
    private String open;
    private String close;
    private String businessStatus;



    public void setBusinessStatus(Market market){
        Calendar holiday = Calendar.getInstance();
        String year = Integer.toString(holiday.get(Calendar.YEAR));
        String month = Integer.toString(holiday.get(Calendar.MONTH)+1);
        String day = Integer.toString(holiday.get(Calendar.DAY_OF_MONTH));
        String date = year+"-"+month+"-"+day;



        if(date.equals(market.getHolidays())){

        }
    }

}

