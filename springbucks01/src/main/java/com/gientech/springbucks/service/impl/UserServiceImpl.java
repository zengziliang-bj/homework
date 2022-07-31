package com.gientech.springbucks.service.impl;

import com.gientech.springbucks.dao.UserDao;
import com.gientech.springbucks.model.User;
import com.gientech.springbucks.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	@Override
	public User getUser() {
		
		return userDao.selectUser();
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
