package com.gientech.springbucks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gientech.springbucks.dao.StudentDao;
import com.gientech.springbucks.dao.impl.StudentDaoImpl;
import com.gientech.springbucks.service.StudentService;
import com.gientech.springbucks.service.impl.StudentServiceImpl;

@Configuration
public class AppactionConfig {
	
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		
		return new StudentDaoImpl();
	}
	
	@Bean("studentService")
	public StudentService getStudentService() {
		
		return new StudentServiceImpl();
	}

}
