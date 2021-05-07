package com.example.job_project.dao;

import com.example.job_project.entity.Market;
import com.example.job_project.entity.MarketTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MarketRepository extends CrudRepository<Market, Integer> {

    @Query(value = "select * from ")
    Market findByName(String name);
}
