package com.teste.primeiro_exemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories

public class PrimeiroExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroExemploApplication.class, args);
	}

}
