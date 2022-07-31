package com.gientech.springbucks.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gientech.springbucks.model.Coffee;
import com.gientech.springbucks.model.CoffeeOrder;
import com.gientech.springbucks.repository.CoffeeOrderRepository;
import com.gientech.springbucks.service.CoffeeOrderService;
import com.gientech.springbucks.util.OrderState;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CoffeeOrderServiceImpl implements CoffeeOrderService {

	@Autowired
	private CoffeeOrderRepository orderRepository;

	@Override
	public CoffeeOrder createOrder(String customer, Coffee... coffee) {
		CoffeeOrder coffeeOrder = new CoffeeOrder();
		coffeeOrder.setCustomer(customer);
		coffeeOrder.setItems(new ArrayList<>(Arrays.asList(coffee)));
		coffeeOrder.setState(OrderState.INIT);

		CoffeeOrder saved = orderRepository.save(coffeeOrder);
		log.info("---New Order: {}", saved);
		return saved;
	}

	@Override
	public boolean updateState(CoffeeOrder order, OrderState state) {
		if (state.compareTo(order.getState()) <= 0) {
			log.warn("---Wrong State order: {}, {}", state, order.getState());
			return false;
		}
		order.setState(state);
		orderRepository.save(order);
		log.info("---Updated Order: {}", order);
		return true;
	}

}
