package com.chepopepe.chepopepe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class ChepopepeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChepopepeApplication.class, args);
	}

}
