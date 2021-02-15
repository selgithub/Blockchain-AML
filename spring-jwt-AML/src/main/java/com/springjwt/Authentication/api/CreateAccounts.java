package com.springjwt.Authentication.api;

import com.springjwt.Authentication.model.Account;
import com.springjwt.Authentication.model.CreateAccount;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("accounts")
public interface CreateAccounts {


    @POST
    @Path("/save")
    Account saveAccount(CreateAccount account);

    @GET
    @Path("/all")
    public ResponseEntity<?> loadAll();
}
