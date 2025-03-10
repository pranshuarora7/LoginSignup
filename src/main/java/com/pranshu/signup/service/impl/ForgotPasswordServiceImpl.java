package com.pranshu.signup.service.impl;

import com.pranshu.signup.model.ResetToken;
import com.pranshu.signup.model.User;
import com.pranshu.signup.repository.ResetTokenRepository;
import com.pranshu.signup.repository.UserRepository;
import com.pranshu.signup.service.ForgotPasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    private final UserRepository userRepository;
    private final ResetTokenRepository resetTokenRepository;

    public ForgotPasswordServiceImpl(UserRepository userRepository, ResetTokenRepository resetTokenRepository) {
        this.userRepository = userRepository;
        this.resetTokenRepository = resetTokenRepository;
    }

    @Override
    public ResponseEntity<String> generateResetToken(String username) {
        Optional<User> user = userRepository.findById(username);
        if (user.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        // Generate a unique reset token
        String token = UUID.randomUUID().toString();

        // Store the token in MongoDB with an expiry time of 1 hour
        ResetToken resetToken = new ResetToken(username, token, Instant.now().plusSeconds(3600));
        resetTokenRepository.save(resetToken);

        return ResponseEntity.ok("Reset token generated: " + token);
    }

    @Override
    public ResponseEntity<String> resetPassword(String token, String newPassword) {
        Optional<ResetToken> resetToken = resetTokenRepository.findByToken(token);
        if (resetToken.isEmpty() || resetToken.get().getExpiryTime().isBefore(Instant.now())) {
            return ResponseEntity.status(400).body("Invalid or expired token");
        }

        String username = resetToken.get().getUsername();
        Optional<User> user = userRepository.findById(username);
        if (user.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        // Update the user's password
        User existingUser = user.get();
        existingUser.setPassword(newPassword);
        userRepository.save(existingUser);

        // Delete the used reset token
        resetTokenRepository.delete(resetToken.get());

        return ResponseEntity.ok("Password reset successfully");
    }
}

