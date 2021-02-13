package com.springjwt.Authentication.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.springjwt.Authentication.api.UserResource;
import com.springjwt.Authentication.model.User;
import com.springjwt.Authentication.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController implements UserResource {

    @Autowired
    private UserService userService;

    @Override
    public User loadById(@PathVariable Long userId) {
        log.info("get user by id");
        return this.userService.findById(userId);
    }

    @Override
    public ResponseEntity<?> loadAll() {
        log.info("get all user");
        return ResponseEntity.accepted().body(this.userService.findAll());
    }

    @Override
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }

    @Override
    public User addUser(User user) {
        log.info("create user");
        return userService.addUser(user);
    }
}
