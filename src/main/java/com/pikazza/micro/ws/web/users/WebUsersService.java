package com.pikazza.micro.ws.web.users;

import java.util.List;

import com.pikazza.micro.ws.web.orders.Orders;

public interface WebUsersService {

	List<Users> getAllUsers();

	Users getUser(String id);

	List<Orders> getOrderByUserId(String id);

	Users postUser(Users user);

	Users putUser(Users user);

}
