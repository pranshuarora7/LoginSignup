package com.pranshu.signup.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Details")  // Ensure correct collection name
public class User {
    @Id
    private String username;  // Acts as _id

    private String name;
    private String email;
    private String password;
    private String phone;  // Ensure it's a String if needed

    // Fields for password reset
    private String resetToken;
    private Date tokenExpiry;

    // Constructors
    public User() {}

    public User(String username, String name, String email, String password, String phone) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setTokenExpiry(Date date) {
        this.tokenExpiry = tokenExpiry;
    }

    public Date getTokenExpiry() {
        return tokenExpiry;
    }
}
