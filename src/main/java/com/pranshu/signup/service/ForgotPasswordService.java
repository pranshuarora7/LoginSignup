package com.pranshu.signup.service;

import org.springframework.http.ResponseEntity;

public interface ForgotPasswordService {
    ResponseEntity<String> generateResetToken(String username);
    ResponseEntity<String> resetPassword(String token, String newPassword);
}

