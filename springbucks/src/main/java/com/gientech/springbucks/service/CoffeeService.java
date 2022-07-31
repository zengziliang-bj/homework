package com.gientech.springbucks.service;

import java.util.Optional;

import com.gientech.springbucks.model.Coffee;

public interface CoffeeService {

	Optional<Coffee> findOneCoffee(String name);
}
