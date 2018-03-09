package com.pikazza.micro.ws.web.users;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pikazza.micro.ws.web.orders.Orders;


@Service
public class WebUsersServiceImpl implements WebUsersService{
	
	
	@Autowired
	protected RestTemplate restTemplate;
	
	
	protected String serviceUrl;

	public WebUsersServiceImpl(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public List<Users> getAllUsers() {
		String url = serviceUrl+"/v1.0/users";
		ResponseEntity<Users[]> responseEntity = restTemplate.getForEntity(url, Users[].class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return Arrays.asList(responseEntity.getBody());
	}


	@Override
	public Users getUser(String id) {
		String url = serviceUrl+"/v1.0/users/"+id;
		ResponseEntity<Users> responseEntity = restTemplate.getForEntity(url, Users.class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return responseEntity.getBody();
	}


	@Override
	public List<Orders> getOrderByUserId(String id) {
		String url = serviceUrl+"/v1.0/users/"+id+"/orders";
		ResponseEntity<Orders[]> responseEntity = restTemplate.getForEntity(url, Orders[].class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public Users postUser(Users user) {
		String url = serviceUrl+"/v1.0/users";
		ResponseEntity<Users> responseEntity = restTemplate.postForEntity(url, user, Users.class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return responseEntity.getBody();
	}

	@Override
	public Users putUser(Users user) {
		String url = serviceUrl+"/v1.0/users"; 
		restTemplate.put(url, user);
		return getUser(user.getUserId());
	}
	
	
}
