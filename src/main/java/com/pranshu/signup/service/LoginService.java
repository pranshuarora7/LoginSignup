package com.pranshu.signup.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<String> authenticateUser(String email, String password);

    ResponseEntity<String> verifyPassword(String email, String password);
}
