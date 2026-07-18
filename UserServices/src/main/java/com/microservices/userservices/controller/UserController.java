package com.microservices.userservices.controller;

import com.microservices.userservices.model.User;
import com.microservices.userservices.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            this.userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.fillInStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
        }
    }

    // Get All User
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList =  this.userService.getAllUsers();
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(userList);
        }
    }

    // Get single user
//    user@GetMapping("/id")
//    public User getUser(@PathVariable String id) {
//
//    }

    // Update user
    // Delete User
}
