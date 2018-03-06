package com.pikazza.micro.ws.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.pikazza.micro.ws.web.orders.WebOrdersController;
import com.pikazza.micro.ws.web.users.WebUsersController;


@Configuration
public class JerseyConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyConfig.class);

    public JerseyConfig() {
    	LOGGER.info(WebOrdersController.class.getName()+"  Registed");
    	register(WebOrdersController.class); 
    	register(WebUsersController.class);
    }

}
