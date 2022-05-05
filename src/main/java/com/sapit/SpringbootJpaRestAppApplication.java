package com.sapit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sapit","com.sapit.model"})
public class SpringbootJpaRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRestAppApplication.class, args);
	}

}
