package com.springcrud.springcrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner -> {
			System.out.println("The Project beans has been loaded");
		};
	}

}
