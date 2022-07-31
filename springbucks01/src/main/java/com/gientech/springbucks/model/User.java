package com.gientech.springbucks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	
	private int id;
	
	private String name;
	
	private String gender;
	
	private String address;
}
