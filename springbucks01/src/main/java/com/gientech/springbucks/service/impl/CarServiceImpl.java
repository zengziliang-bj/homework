package com.gientech.springbucks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gientech.springbucks.dao.CarDao;
import com.gientech.springbucks.model.Car;
import com.gientech.springbucks.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao cardao;
	
	@Override
	public Car getOneCar() {
		return cardao.getOneCar();
	}

}
