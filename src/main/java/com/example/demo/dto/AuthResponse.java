package com.example.demo.dto;

public class AuthResponse {

    private String token;

    // Single constructor
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Optional setter (if needed)
    public void setToken(String token) {
        this.token = token;
    }
}
