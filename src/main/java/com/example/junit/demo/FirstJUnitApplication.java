package com.example.junit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class FirstJUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstJUnitApplication.class, args);
	}

}
