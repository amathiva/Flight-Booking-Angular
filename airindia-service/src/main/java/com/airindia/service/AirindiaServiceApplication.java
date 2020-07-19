package com.airindia.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirindiaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirindiaServiceApplication.class, args);
	}

}
