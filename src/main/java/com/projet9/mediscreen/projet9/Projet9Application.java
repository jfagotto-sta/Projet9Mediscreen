package com.projet9.mediscreen.projet9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Projet9Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet9Application.class, args);
	}

}
