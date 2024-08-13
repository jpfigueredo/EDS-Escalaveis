package com.edu.infnet.DR3TP1Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Dr3Tp1ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dr3Tp1ServerApplication.class, args);
	}

}

