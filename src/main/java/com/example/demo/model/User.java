package com.example.demo.model;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Set<String> roles = new HashSet<>();
}
