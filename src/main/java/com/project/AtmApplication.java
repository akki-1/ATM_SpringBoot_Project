package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com")
@EntityScan("com")
@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

}
