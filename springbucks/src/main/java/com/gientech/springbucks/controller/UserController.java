package com.gientech.springbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.gientech.springbucks.model.User;
import com.gientech.springbucks.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/addUser")
	public String addUser(String username, String password) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		userService.addUser(user);
		
		return JSON.toJSONString(user);
	}
}
