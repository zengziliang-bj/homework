package com.gientech.springbucks.dao.impl;

import com.gientech.springbucks.dao.UserDao;
import com.gientech.springbucks.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectUser() {
		
		User user = new User();
		user.setAddress("北京市顺义区顺安南路68号");
		user.setGender("女");
		user.setName("三藏");
		user.setId(123);
		
		return user;
	}

}
