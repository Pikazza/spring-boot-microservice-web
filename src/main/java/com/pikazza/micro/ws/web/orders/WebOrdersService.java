package com.pikazza.micro.ws.web.orders;

import java.util.List;

public interface WebOrdersService {

	List<Orders> getAllOrders();

	Orders getOrder(String id);

}
