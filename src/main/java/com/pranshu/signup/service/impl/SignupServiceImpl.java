package com.pranshu.signup.service.impl;

import com.pranshu.signup.model.User;
import com.pranshu.signup.repository.UserRepository;
import com.pranshu.signup.service.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupServiceImpl implements SignupService {

    private static final Logger log = LoggerFactory.getLogger(SignupServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public SignupServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> createUser(User user) {
        if (userRepository.existsById(user.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        user.setPassword(user.getPassword());
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @Override
    public ResponseEntity<String> updateUserProfile(String username, User updatedUser) {
        Optional<User> userOpt = userRepository.findById(username);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOpt.get();
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        userRepository.save(user);

        return ResponseEntity.ok("Profile updated successfully");
    }


    @Override
    public String deleteUser(String username) {
        userRepository.deleteById(username);
        return "Success";
    }

    @Override
    public User getPersonFromUsername(String username) {
        log.info("Finding User: {} ......", username);
        return userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("Person not found with username: " + username));
    }

    public Optional<User> passwordMatching(String username) {
        return userRepository.findById(username);
    }

}
