package com.example.demo.security;

import java.util.*;

public class JwtTokenProvider {

    public String createToken(Long id, String email, Set<String> roles) {
        return id + "|" + email + "|" + String.join(",", roles);
    }

    public boolean validateToken(String t) {
        return t != null && t.split("\\|").length >= 3;
    }

    public String getEmail(String t) {
        return t.split("\\|")[1];
    }

    public Set<String> getRoles(String t) {
        return Set.of(t.split("\\|")[2].split(","));
    }

    public Long getUserId(String t) {
        return Long.valueOf(t.split("\\|")[0]);
    }
}
