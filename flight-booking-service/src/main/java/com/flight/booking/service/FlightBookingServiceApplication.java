package com.flight.booking.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class FlightBookingServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		System.out.println("load balancer");
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FlightBookingServiceApplication.class, args);
		System.out.println("flight booking called");
	}

}
