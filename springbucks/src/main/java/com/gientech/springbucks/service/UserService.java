package com.gientech.springbucks.service;

import java.util.List;

import com.gientech.springbucks.model.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	
	void addUser(User user);
	
	void modifyUserById(User user);
	
	User queryUserById(int id);
	
	List<User> queryUserList();
	
	PageInfo<User> getUserByPage(int pageNum, int pagesize);

	int deleteUserById(int id);

}
