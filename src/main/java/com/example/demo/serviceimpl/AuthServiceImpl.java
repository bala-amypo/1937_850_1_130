package com.example.demo.serviceimpl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.HashSet;

public class AuthServiceImpl {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        user.setRoles(new HashSet<>(user.getRoles()));
        return userRepository.save(user);
    }

    public User authenticate(String email, String password) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
