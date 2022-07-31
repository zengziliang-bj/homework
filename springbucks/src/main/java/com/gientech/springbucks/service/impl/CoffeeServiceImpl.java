package com.gientech.springbucks.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gientech.springbucks.model.Coffee;
import com.gientech.springbucks.repository.CoffeeRepository;
import com.gientech.springbucks.service.CoffeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeRepository coffeeRepository;

	@Override
	public Optional<Coffee> findOneCoffee(String name) {

//		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", exact().ignoreCase());
//		Optional<Coffee> coffee = coffeeRepository.findOne(Example.of(Coffee.builder().name(name).build(), matcher));
//		
//		log.info("Coffee Found: {}", coffee);

		return Optional.empty();
	}

}
