package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.example.demo.common", "com.example.demo.reset"}
		)
public class ConstructorInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructorInjectionApplication.class, args);
	}

}
