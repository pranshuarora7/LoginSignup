package com.pranshu.signup.service.impl;

import com.pranshu.signup.model.User;
import com.pranshu.signup.repository.UserRepository;
import com.pranshu.signup.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @Override
    public ResponseEntity<String> verifyPassword(String username, String password) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            return ResponseEntity.ok("Password matches");
        }
        return ResponseEntity.status(401).body("Incorrect password");
    }
}
