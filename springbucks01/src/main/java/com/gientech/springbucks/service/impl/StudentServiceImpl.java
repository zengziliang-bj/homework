package com.gientech.springbucks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gientech.springbucks.dao.StudentDao;
import com.gientech.springbucks.model.Student;
import com.gientech.springbucks.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao  dao;
	
	@Override
	public Student getOneStudent() {
		
		return dao.getOneStudent();
	}

}
