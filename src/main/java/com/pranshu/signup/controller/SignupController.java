package com.pranshu.signup.controller;

import com.pranshu.signup.model.User;
import com.pranshu.signup.service.SignupService;
import com.pranshu.signup.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class SignupController {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);
    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return signupService.createUser(user);
    }

    @GetMapping(value = Constants.UrlPaths.USER_DETAILS)
    public ResponseEntity<User> getUserDetailsFromUsername(
            @RequestParam(name = Constants.UrlPathParameters.USERNAME, required = true) String username,
            @RequestParam(name = Constants.UrlPathParameters.PASSWORD, required = true) String password)
    {
        log.info("Received call for getting details for user: {}", username);
        return ResponseEntity.ok(signupService.getPersonFromUsername(username));
    }

    @DeleteMapping("/delete-account")
    public String deleteUser(@RequestParam String username) {
        return signupService.deleteUser(username);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<String> updateProfile(@RequestParam String username, @RequestBody User updatedUser) {
        return signupService.updateUserProfile(username, updatedUser);
    }
}
