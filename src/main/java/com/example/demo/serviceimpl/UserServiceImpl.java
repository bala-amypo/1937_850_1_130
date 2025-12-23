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
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public User createUser(User user, Set<String> rolesSet) {
        List<String> rolesList = new ArrayList<>(rolesSet); // fix Set -> List
        user.setRoles(rolesList);
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public String generateToken(User user) {
        List<String> rolesList = user.getRoles(); // already List
        return jwtTokenProvider.createToken(user.getId(), user.getEmail(), rolesList);
    }
}
