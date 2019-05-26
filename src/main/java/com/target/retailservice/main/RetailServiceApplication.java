package com.target.retailservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.target.retailservice")
public class RetailServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RetailServiceApplication.class);
	}

}
