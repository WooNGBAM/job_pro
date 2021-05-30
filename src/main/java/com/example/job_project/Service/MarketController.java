package com.example.job_project.Service;

import com.example.job_project.dao.MarketRepository;
import com.example.job_project.entity.Business;
import com.example.job_project.entity.Market;
import com.example.job_project.entity.SimpleList;
import com.example.job_project.entity.SpecList;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/********************************************************************
 * 전체적으로 Date, Calender 대신 LocalTime, LocalDate 사용할것
 *
 *
 *
 *
 *
 *
 *
 ********************************************************************/
@RestController
@RequestMapping("/market")
public class MarketController {

    private MarketRepository repository;

    public MarketController(MarketRepository repository) {
        this.repository = repository;
    }


    //휴무일 등록
    @Transactional // 직접적인 수정 ex)UPDATE 수행시 필요
    @PostMapping("/holi")
    public void postMarketHoliday(@RequestBody Market holiday){
        System.out.println(holiday.getHolidays().getClass());
        SimpleDateFormat dataParser = new SimpleDateFormat("yyyy-MM-dd");
        for (Date day : holiday.getHolidays())
        {
            repository.saveHoli(holiday.getId(), dataParser.format(day));
            System.out.println(dataParser.format(day).getClass());
        }

    }

    //점포등록
    @PostMapping
    public Market postMarket(@RequestBody(required = false) Market marketT){

        return repository.save(marketT);
    }

    //점포삭제
    @DeleteMapping
    public String deleteMarket(int id){
        repository.deleteById(id);
        String tmpTxt = "id : ";
        String tmpId = Integer.toString(id);
        return tmpTxt + tmpId;
    }

    //레벨 오름차순 정렬
    @GetMapping("/testttt")
    public List<Market> getMarketLevel(){
        return (List<Market>) repository.findAllByOrderByLevelAsc();
    }




    //점포 목록 조회
    @GetMapping("/search")
    public List<SimpleList> getMarketSimple() {

        List<SimpleList> simpleLists = new ArrayList<SimpleList>();
        LocalDate today = LocalDate.now();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dayOfWeek = new SimpleDateFormat("E", Locale.ENGLISH);
        System.out.println(repository.findById(1).get());
        LocalTime lT = LocalTime.now();
        int size = repository.findAllByOrderByLevelAsc().size();

        for(int i = 0 ; i<size ; i++) {
            Market rp = repository.findAllByOrderByLevelAsc().get(i);
            SimpleList simple = new SimpleList();
            simple.setName(rp.getName());
            simple.setDescription(rp.getDescription());
            simple.setLevel(rp.getLevel());




            System.out.println(size);
            System.out.println(rp.getId()+"  "+dayOfWeek.format(today)+"  ");
            System.out.println(lT);
            System.out.println(lT);
            System.out.println(repository.findByIdOpen(rp.getId(), dayOfWeek.format(today)));//쿼리 수행 후 리턴값 null... 왜?//


            simple.setBusinessStatus(setBusiStat(rp.getId(), today));
            simpleLists.add(simple);
        }
        return simpleLists;
    }


    //점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, level, 조회 일자 기준 영업시간 3일치(오픈시간, 마감시간, 영업상태, 요일))

    @GetMapping("/find")
    public SpecList getMarketFind(int id) {
        SpecList specList = new SpecList();
        Market rp = repository.findById(id).get();
        specList.setId(rp.getId());
        specList.setName(rp.getName());
        specList.setDescription(rp.getDescription());
        specList.setAddress(rp.getAddress());
        specList.setPhone(rp.getPhone());
        specList.setLevel(rp.getLevel());


        List<Business> lB = new ArrayList<Business>();

        //specList.setBusinessDays();
        for(int i = 0;i<3;i++){
            Business weekEnd = new Business();
            weekEnd.setBusinessStatus("WEEKEND");
            weekEnd.setClose(null);
            weekEnd.setOpen(null);
            LocalDate localDate = LocalDate.now();
            System.out.println(localDate.getDayOfWeek().getValue());
            LocalDate loD = localDate.plusDays(i);
            String date = loD.format(DateTimeFormatter.ofPattern("E", Locale.ENGLISH));
            System.out.println(date);
            System.out.println(rp.getBusinessTimes().get(0));
            if(loD.getDayOfWeek().getValue() == 6){
                weekEnd.setDay("Saturday");
                lB.add(weekEnd);
            }else if(loD.getDayOfWeek().getValue() == 7){
                weekEnd.setDay("Sunday");
                lB.add(weekEnd);
            }else{
                lB.add(rp.getBusinessTimes().get(loD.getDayOfWeek().getValue()-1));
                lB.get(i).setBusinessStatus(setBusiStat(id, loD));
            }



        }
        specList.setBusinessDays(lB);
        return specList;
    }
    public String setBusiStat(int id, LocalDate today){ //id와 오늘날짜를 받아 현재 영업여부 판단
        LocalTime lT = LocalTime.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dayOfWeek = today.format(DateTimeFormatter.ofPattern("E", Locale.ENGLISH));
        if(repository.existsByHoli(id, date)){ //휴무일 여부 확인
            return "HOLIDAY";
        }else if(repository.findByIdOpen(id, dayOfWeek).isBefore(lT) && lT.isBefore(repository.findByIdClose(id, dayOfWeek))){
            return "OPEN";
        }else{
            return "CLOSE";
        }

    }


}

