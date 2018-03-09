package com.pikazza.micro.ws.web.orders;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Path("/v1.0")
@Controller
public class WebOrdersController {
	
	private Logger logger = Logger
			.getLogger(this.getClass().getName());
	
	@Autowired
	private WebOrdersService webOrdersService;
	
	@GET
	@Path("/orders")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@RequestMapping("/users")
	public List<Orders> all() {
		List<Orders> users = webOrdersService.getAllOrders();
		return users;
	}
	
	@GET
	@Path("/orders/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@RequestMapping("/users/{id}")
	public Orders byId(@PathParam("id") String id) {
		Orders user = webOrdersService.getOrder(id);
		return user;
	}
	
	@POST
	@Path("/orders")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@RequestMapping("/users/{id}")
	public Orders postUser( Orders orders) {
		Orders order = webOrdersService.postOrder(orders);
		return order;
	}
	
	@PUT
	@Path("/orders")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@RequestMapping("/users/{id}")
	public Orders putUser( Orders orders) {
		logger.info("updating new user ");
		Orders order = webOrdersService.putOrder(orders);
		logger.info("updating new user completed ");
		return order;
	}
}
