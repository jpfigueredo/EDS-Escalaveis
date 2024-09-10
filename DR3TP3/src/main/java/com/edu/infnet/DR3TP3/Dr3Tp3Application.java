package com.edu.infnet.DR3TP3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.edu.infnet.DR3TP3.repository.jpa")
@EnableR2dbcRepositories(basePackages = "com.edu.infnet.DR3TP3.repository.r2dbc")
public class Dr3Tp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Dr3Tp3Application.class, args);
	}

}
