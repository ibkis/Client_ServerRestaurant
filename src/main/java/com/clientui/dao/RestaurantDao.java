package com.clientui.dao;

import com.clientui.model.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{
       //public List<Restaurant> findAllOrderBymoyenDesc();
}
