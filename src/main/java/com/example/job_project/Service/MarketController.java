package com.example.job_project.Service;

import com.example.job_project.dao.MarketRepository;
import com.example.job_project.entity.Market;
import com.example.job_project.entity.SimpleList;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/market")
public class MarketController {

    private MarketRepository repository;

    public MarketController(MarketRepository repository) {
        this.repository = repository;
    }

    //목록조회, 점포 상세정보 조회 必



    @PutMapping
    public Market putMarket(Market market){
        return repository.save(market);
    }

    @Transactional
    @PostMapping("/holi")//휴무일 등록
    public void postMarketHoliday(@RequestBody Market holiday){
        for (String day: holiday.getHolidays())
        {
            repository.saveHoli(holiday.getId(), day);
        }

    }
    @PostMapping
    public Market postMarket(@RequestBody(required = false) Market marketT){
        repository.save(marketT);
        return marketT;
    }

    @DeleteMapping
    public String deleteMarket(int id){
        repository.deleteById(id);
        String tmpTxt = "id : ";
        String tmpId = Integer.toString(id);
        return tmpTxt + tmpId;
    }

    @GetMapping
    public List<Market> getMarketName(){
        System.out.println(repository.findAll().getClass());

        return (List<Market>) repository.findAll();
    }

    @GetMapping("/search")
    public List<SimpleList> getMarketSimple(){
        return repository.findAllSimple();

    }



}
