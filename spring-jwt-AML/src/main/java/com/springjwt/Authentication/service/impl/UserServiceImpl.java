package com.springjwt.Authentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springjwt.Authentication.model.User;
import com.springjwt.Authentication.repository.UserRepository;
import com.springjwt.Authentication.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) throws AccessDeniedException {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userRepository.save(user);
        return findByUsername(user.getUsername());
    }
}
