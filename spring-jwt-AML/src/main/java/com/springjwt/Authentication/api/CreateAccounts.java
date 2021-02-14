package com.springjwt.Authentication.api;

import com.springjwt.Authentication.model.Account;
import com.springjwt.Authentication.model.CreateAccount;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("accounts")
public interface CreateAccounts {


    @POST
    @Path("/save")
    Account saveAccount(CreateAccount account);
}
