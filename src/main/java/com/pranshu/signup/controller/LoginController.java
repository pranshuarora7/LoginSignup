package com.pranshu.signup.controller;

import com.pranshu.signup.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        return loginService.authenticateUser(username, password);
    }
    @PostMapping("/password-match")
    public ResponseEntity<String> verifyPassword(@RequestParam String username, @RequestParam String password) {
        return loginService.verifyPassword(username, password);
    }
}
