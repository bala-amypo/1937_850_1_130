package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

public class User {

    private Long id;
    private String email;
    private String password;
    private String name;
    private Set<String> roles;
    private LocalDateTime createdAt;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User u = new User();

        public Builder email(String email) {
            u.email = email;
            return this;
        }

        public Builder password(String password) {
            u.password = password;
            return this;
        }

        public Builder name(String name) {
            u.name = name;
            return this;
        }

        public Builder roles(Set<String> roles) {
            u.roles = roles;
            return this;
        }

        public Builder createdAt(LocalDateTime time) {
            u.createdAt = time;
            return this;
        }

        public User build() {
            return u;
        }
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public Set<String> getRoles() { return roles; }
}
