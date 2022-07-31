package com.gientech.springbucks.service;

import com.gientech.springbucks.model.Coffee;
import com.gientech.springbucks.model.CoffeeOrder;
import com.gientech.springbucks.util.OrderState;

public interface CoffeeOrderService {

	CoffeeOrder createOrder(String customer, Coffee...coffee);
	
	boolean updateState(CoffeeOrder order, OrderState state);
}
