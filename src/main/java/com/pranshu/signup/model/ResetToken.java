package com.pranshu.signup.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "reset_tokens")
public class ResetToken {
    @Id
    private String token;
    private String username;
    private Instant expiryTime;

    public ResetToken(String username, String token, Instant expiryTime) {
        this.username = username;
        this.token = token;
        this.expiryTime = expiryTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Instant expiryTime) {
        this.expiryTime = expiryTime;
    }

    // Getters and Setters
}
