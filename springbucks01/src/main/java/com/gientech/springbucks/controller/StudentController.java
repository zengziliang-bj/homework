package com.gientech.springbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gientech.springbucks.model.Student;
import com.gientech.springbucks.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/getOneStudent")
	public Student getOneStudent() {
		return service.getOneStudent();
	}
}
