package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER (CREATE)
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }

    // ✅ LOGIN (READ)
    @PostMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password) {

        User user = userService.getUserByEmail(email);

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }

    // ✅ GET USER BY ID (READ)
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // ✅ DELETE USER (DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
