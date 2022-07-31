package com.gientech.springbucks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories
@MapperScan(basePackages = "com.gientech.springbucks.mapper")
@SpringBootApplication
public class SpringbucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

}
