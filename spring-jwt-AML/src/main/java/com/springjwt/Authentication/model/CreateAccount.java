package com.springjwt.Authentication.model;

public class CreateAccount {
    String Username;
    String accountname;

    public CreateAccount() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
}
