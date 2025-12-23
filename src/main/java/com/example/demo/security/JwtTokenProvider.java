package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        // implement token validation logic
        return true;
    }

    public String getEmail(String token) {
        // extract email from token
        return "user@example.com";
    }

    public Set<String> getRoles(String token) {
        // extract roles from token as Set
        return Set.of("USER");
    }

    public String createToken(Long userId, String email, List<String> roles) {
        // implement token creation logic using userId, email, roles
        return "dummy-jwt-token";
    }
}
