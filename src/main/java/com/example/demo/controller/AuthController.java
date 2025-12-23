package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller", description = "Authentication APIs")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Dummy login logic
        return "JWT-Token-Here";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        // Dummy register logic
        return "User registered successfully";
    }
}
