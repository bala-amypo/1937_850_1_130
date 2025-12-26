package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.serviceimpl.AuthServiceImpl;

import java.time.LocalDateTime;
import java.util.HashSet;

public class AuthController {

    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    public User register(RegisterRequest req) {
        User user = User.builder()
                .email(req.getEmail())
                .password(req.getPassword())
                .name(req.getName())
                .roles(new HashSet<>(req.getRoles()))
                .createdAt(LocalDateTime.now())
                .build();

        return authService.register(user);
    }

    public User login(AuthRequest r) {
        return authService.authenticate(r.getEmail(), r.getPassword());
    }
}
