package com.springjwt.Authentication.conf;

import javax.ws.rs.ApplicationPath;

import com.springjwt.Authentication.controller.AccountCreation;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.springjwt.Authentication.controller.AuthenticationController;
import com.springjwt.Authentication.controller.UserController;
import com.springjwt.Authentication.exception.GlobalExceptionHandler;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
//		packages("com.budget.budgettracker");
        register(UserController.class);
        register(AccountCreation.class);
        register(AuthenticationController.class);
        register(GlobalExceptionHandler.class);
    }
}
