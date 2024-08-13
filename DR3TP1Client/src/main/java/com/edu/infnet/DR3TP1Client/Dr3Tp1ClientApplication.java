package com.edu.infnet.DR3TP1Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Dr3Tp1ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dr3Tp1ClientApplication.class, args);
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello from Microservice!";
	}

}
