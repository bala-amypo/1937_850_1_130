package com.example.demo.serviceimpl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String registerUser(User user, Set<String> rolesSet) {
        // Fix Set -> List conversion
        List<String> rolesList = new ArrayList<>(rolesSet);

        user.setRoles(rolesList);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return jwtTokenProvider.createToken(user.getId(), user.getEmail(), rolesList);
    }
}
