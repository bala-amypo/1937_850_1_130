package com.example.demo.security;

import java.util.List;

public class JwtTokenProvider {

    // Dummy methods; implement actual JWT logic as per your project
    public boolean validateToken(String token) {
        // Validate the JWT token
        return true;
    }

    public String getEmail(String token) {
        // Extract email from JWT token
        return "user@example.com";
    }

    public List<String> getRoles(String token) {
        // Extract roles from JWT token
        return List.of("USER");
    }

    public String createToken(String email) {
        // Create a JWT token using email
        return "jwt-token";
    }

    public String createToken(Long userId, String email, List<String> roles) {
        // Overloaded method with multiple parameters
        return "jwt-token";
    }
}
