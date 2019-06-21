package com.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.practice.mapper")
public class SpringBootBatchExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchExampleApplication.class, args);
	}

}
