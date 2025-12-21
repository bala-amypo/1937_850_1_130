package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // REQUIRED constructor order
    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse registerUser(RegisterRequest req) {
        if (userRepository.findByEmail(req.email).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setName(req.name);
        user.setEmail(req.email);
        user.setPassword(passwordEncoder.encode(req.password));
        user.setRoles(req.roles);

        userRepository.save(user);

        AuthResponse res = new AuthResponse();
        res.token = jwtTokenProvider.createToken(
                user.getId(), user.getEmail(), user.getRoles());

        return res;
    }

    @Override
    public AuthResponse loginUser(LoginRequest req) {
        User user = userRepository.findByEmail(req.email)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (!passwordEncoder.matches(req.password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        AuthResponse res = new AuthResponse();
        res.token = jwtTokenProvider.createToken(
                user.getId(), user.getEmail(), user.getRoles());

        return res;
    }
}