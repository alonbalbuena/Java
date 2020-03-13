package com.dawes;

import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class charo_Spring_Web_Thymeleaf {

	public static void main(String[] args) {
		SpringApplication.run(charo_Spring_Web_Thymeleaf.class, args);
		Persistence.generateSchema("jpa", null);
	}

}
