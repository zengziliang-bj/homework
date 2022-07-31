package com.gientech.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gientech.springbucks.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
