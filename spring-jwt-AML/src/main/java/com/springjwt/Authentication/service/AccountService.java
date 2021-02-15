package com.springjwt.Authentication.service;

import com.springjwt.Authentication.model.Account;
import com.springjwt.Authentication.model.User;

import java.util.List;
import java.util.Optional;

public interface AccountService{
    public Account addAccount (Account account);
     public List<Account> findAll();

}
