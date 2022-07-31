package com.gientech.springbucks.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gientech.springbucks.model.User;

@Repository
public interface UserMapper {

	int insertUser(User user);

	int updateUserById(User user);

	User selectUserById(Integer id);

	List<User> selectAllUsers();

	int deleteUserById(int id);

}
