package com.gientech.springbucks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class SpringbucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

}
