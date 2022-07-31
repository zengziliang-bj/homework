package com.gientech.springbucks.dao.impl;

import org.springframework.stereotype.Repository;

import com.gientech.springbucks.dao.CarDao;
import com.gientech.springbucks.model.Car;


@Repository
public class CarDaoImpl implements CarDao {

	@Override
	public Car getOneCar() {
		
		return new Car("白色","大奔C600");
	}

}
