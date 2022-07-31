package com.gientech.springbucks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gientech.springbucks.mapper.UserMapper;
import com.gientech.springbucks.model.User;
import com.gientech.springbucks.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public void addUser(User user) {

		try {
			userMapper.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void modifyUserById(User user) {

		try {
			userMapper.updateUserById(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User queryUserById(int id) {

		return userMapper.selectUserById(id);
	}

	@Override
	public List<User> queryUserList() {
		return userMapper.selectAllUsers();
	}

	@Override
	public PageInfo<User> getUserByPage(int pageNum, int pagesize) {
		// 开始分页
		PageHelper.startPage(pageNum, pagesize);
		List<User> user = userMapper.selectAllUsers();
		PageInfo<User> userPageInfo = new PageInfo<>(user);
		return userPageInfo;
	}

	@Transactional
	@Override
	public int deleteUserById(int id) {
		
		try {
			userMapper.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
