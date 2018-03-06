package com.pikazza.micro.ws.web.orders;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;



@Path("/v1.0")
@Controller
public class WebOrdersController {
	
	private Logger logger = Logger
			.getLogger(this.getClass().getName());
	
	@Autowired
	private WebOrdersService ordersService;
	
	@GET
	@Path("/orders")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@RequestMapping("/users")
	public List<Orders> all() {
		logger.info("accounts-microservice all() invoked");
		List<Orders> users = ordersService.getAllOrders();
		logger.info("accounts-microservice all() found: " + users.size());
		return users;
	}
	
	@GET
	@Path("/orders/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@RequestMapping("/users/{id}")
	public Orders byId(@PathParam("id") String id) {
		logger.info("accounts-microservice byId() invoked: " + id);
		Orders user = ordersService.getOrder(id);
		logger.info("accounts-microservice byId() found: " + user);
		return user;
	}
}
