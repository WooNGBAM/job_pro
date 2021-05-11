package com.example.job_project.dao;

import com.example.job_project.entity.Market;
import com.example.job_project.entity.SimpleList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MarketRepository extends CrudRepository<Market, Integer> {


    @Modifying
    @Query(value = "insert into market_holidays (market_id , holidays ) values ( ?1, ?2 )", nativeQuery = true)
    void saveHoli(int id, String holidays);

    @Query(value = "select * from market_list", nativeQuery = true)
    List<SimpleList> findAllSimple();


}

