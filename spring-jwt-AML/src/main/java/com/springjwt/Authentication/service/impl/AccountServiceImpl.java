package com.springjwt.Authentication.service.impl;

import com.springjwt.Authentication.repository.AccountRepository;
import com.springjwt.Authentication.service.AccountService;
import com.springjwt.Authentication.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accrepo;

    @Override
    public Account addAccount(Account account) {
        return accrepo.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accrepo.findAll();
    }
}
