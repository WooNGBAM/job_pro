package com.example.job_project;

import com.example.job_project.dao.MarketRepository;
import com.example.job_project.entity.Market;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarketControler{
    private MarketRepository repository;

    public MarketControler(MarketRepository repository) {
        this.repository = repository;
    }

    @PutMapping(value = "/market")
    public Market putMarket(Market market){
        return repository.save(market);
    }


    @PostMapping(value = "/market")
    public Market postMarket(Market market){
        return repository.save(market);
    }

    @DeleteMapping(value = "/market")
    public void deleteMarket(int id){
        repository.deleteById(id);
    }

    @GetMapping(value = "/market")
    public Market getMarket(int id){
        return repository.findById(id).orElse(null);
    }

    @GetMapping(value = "/market/name")
    public Market getMarket(String name){
        return repository.findByName(name);
    }

}
