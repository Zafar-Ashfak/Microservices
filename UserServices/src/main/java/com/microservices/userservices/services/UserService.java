package com.microservices.userservices.services;

import com.microservices.userservices.exceptions.ResourceNotFoundException;
import com.microservices.userservices.model.User;
import com.microservices.userservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(String id) {
        return this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with ID " + id + " not found"));
    }

    public User update(User user, String id) {
        User existingUser = this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with ID " + id + " not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAbout(user.getAbout());

        return this.userRepository.save(existingUser);
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }
}
