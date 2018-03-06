package com.pikazza.micro.ws.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.pikazza.micro.ws.web.orders.WebOrdersServiceImpl;
import com.pikazza.micro.ws.web.users.WebUsersServiceImpl;

@SpringBootApplication
@EnableDiscoveryClient
public class WebMicroServer {

	public static final String ORDERS_SERVICE_URL = "http://PIKAZZA-ORDERS-MICROSERVICE";
	public static final String USERS_SERVICE_URL = "http://PIKAZZA-USERS-MICROSERVICE";
	
	public static void main(String[] args) {
		
		SpringApplication.run(WebMicroServer.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebOrdersServiceImpl webOrdersServiceImpl(){
		return new WebOrdersServiceImpl(ORDERS_SERVICE_URL);
	} 
	@Bean
	public WebUsersServiceImpl webUsersServiceImpl(){
		return new WebUsersServiceImpl(USERS_SERVICE_URL);
	}
}
