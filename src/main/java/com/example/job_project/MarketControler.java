package com.example.job_project;

import com.example.job_project.dao.MarketRepository;
import com.example.job_project.entity.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class MarketControler{
    @Autowired
    private MarketRepository repository;

    public MarketControler(MarketRepository repository) {
        this.repository = repository;
    }


    @PutMapping(value = "/market")
    public Market putMarket(Market market){

        return repository.save(market);
    }


    @PostMapping(value = "/market")
    public Object postMarket(Market market){

        repository.save(market);
        return market.getId();
    }

    @DeleteMapping(value = "/market")
    public void deleteMarket(int id){
        repository.deleteById(id);
    }

    @GetMapping(value = "/market")
    public Market getMarket(int id){
        return repository.findById(id).orElse(null);
    }


}
