package com.pikazza.micro.ws.web.orders;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebOrdersServiceImpl implements WebOrdersService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	
	protected String serviceUrl;
	
	public WebOrdersServiceImpl(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public List<Orders> getAllOrders() {
		String url = serviceUrl+"/v1.0/orders";
		ResponseEntity<Orders[]> responseEntity = restTemplate.getForEntity(url, Orders[].class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public Orders getOrder(String id) {
		String url = serviceUrl+"/v1.0/orders/"+id;
		ResponseEntity<Orders> responseEntity = restTemplate.getForEntity(url, Orders.class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return responseEntity.getBody();
	}

	@Override
	public Orders postOrder(Orders orders) {
		String url = serviceUrl+"/v1.0/orders";
		ResponseEntity<Orders> responseEntity = restTemplate.postForEntity(url,orders, Orders.class);
		System.out.println("Pikazza Output "+ responseEntity.getBody());
		return responseEntity.getBody();
	}

	@Override
	public Orders putOrder(Orders orders) {
		String url = serviceUrl+"/v1.0/orders"; 
		restTemplate.put(url, orders);
		return getOrder(orders.getOrderId());
	}
	
	
}
