package com.gientech.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gientech.springbucks.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long>{

}
