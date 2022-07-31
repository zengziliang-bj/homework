package com.gientech.springbucks.dao.impl;


import com.gientech.springbucks.dao.StudentDao;
import com.gientech.springbucks.model.Student;


public class StudentDaoImpl implements StudentDao {

	@Override
	public Student getOneStudent() {
		return new Student("张三",18);
	}

}
