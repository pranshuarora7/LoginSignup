package com.pranshu.signup.service;

import com.pranshu.signup.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface SignupService {
    ResponseEntity<String> createUser(User user);

    String deleteUser(String username);

    User getPersonFromUsername(String username);

    Optional<User> passwordMatching(String username);

    ResponseEntity<String> updateUserProfile(String username, User updatedUser);
}
