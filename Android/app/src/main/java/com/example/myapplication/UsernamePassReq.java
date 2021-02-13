package com.example.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.http.ResponseEntity;

import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsernamePassReq {
    public String username;
    public String password;

    public UsernamePassReq() {
    }

    public UsernamePassReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
