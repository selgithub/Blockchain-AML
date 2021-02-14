package com.springjwt.Authentication.controller;

import com.springjwt.Authentication.model.CreateAccount;
import com.springjwt.Authentication.model.User;
import com.springjwt.Authentication.repository.UserRepository;
import com.springjwt.Authentication.service.AccountService;
import com.springjwt.Authentication.api.CreateAccounts;
import com.springjwt.Authentication.model.Account;
import com.springjwt.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.stellar.sdk.KeyPair;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Controller
public class AccountCreation implements CreateAccounts {

    @Autowired
    AccountService acctservice;

    @Autowired
    UserRepository us;

    User user1;
    Account createacc;
    @Override
    public Account saveAccount(CreateAccount account)  {
        //
        KeyPair pair = KeyPair.random();

        System.out.println(new String(pair.getSecretSeed()));
        System.out.println(pair.getAccountId());
//        String friendbotUrl = String.format("https://friendbot.stellar.org/?addr=%s",System.out.println(pair.getAccountId());
//        InputStream response = null;
//        try {
//            response = new URL(friendbotUrl).openStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String body = new Scanner(response, "UTF-8").useDelimiter("\\A").next();
//        System.out.println("SUCCESS! You have a new account :)\n" + body);
//////}}
////

        user1=us.findByUsername(account.getUsername());
        createacc = new Account();
        createacc.setAccountName(account.getAccountname());
        createacc.setPivatekey(new String(pair.getSecretSeed()));
        createacc.setPublickey(new String(pair.getPublicKey()));
        createacc.setUser(user1);

        return acctservice.addAccount(createacc);
    }
}
