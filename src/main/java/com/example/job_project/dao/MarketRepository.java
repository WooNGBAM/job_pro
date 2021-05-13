package com.example.job_project.dao;

import com.example.job_project.entity.Business;
import com.example.job_project.entity.Market;
import com.example.job_project.entity.SimpleList;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


public interface MarketRepository extends CrudRepository<Market, Integer> {


    @Modifying
    @Query(value = "insert into market_holidays (market_id , holidays ) values ( ?1, ?2 )", nativeQuery = true)
    void saveHoli(int id, String holidays);

    List<Market> findAllByOrderByLevelAsc();

    @Query(value = "select exists(select * from market_holidays where market_id = ?1 AND holidays = ?2) as success", nativeQuery = true)
    Boolean existsByHoli(int id, String today);//오늘날짜와 id를 받아 휴무일DB에 등록이 되어있는지 확인 휴무일로 등록이 되어있다면 true




}

