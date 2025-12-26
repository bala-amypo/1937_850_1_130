package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.*;

public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository r, PasswordEncoder e, JwtTokenProvider j) {
        repo = r; encoder = e; jwt = j;
    }

    public ResponseEntity<?> register(RegisterRequest req) {
        if (repo.findByEmail(req.getEmail()).isPresent())
            return ResponseEntity.status(409).build();

        User u = User.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .roles(req.getRoles())
                .name(req.getName())
                .build();

        repo.save(u);
        return ResponseEntity.ok(new AuthResponse(
                jwt.createToken(1L, u.getEmail(), u.getRoles())
        ));
    }

    public ResponseEntity<?> login(AuthRequest r) {
        User u = repo.findByEmail(r.getEmail()).orElse(null);
        if (u == null || !encoder.matches(r.getPassword(), u.getPassword()))
            return ResponseEntity.status(401).build();

        return ResponseEntity.ok(new AuthResponse(
                jwt.createToken(u.getId(), u.getEmail(), u.getRoles())
        ));
    }
}
