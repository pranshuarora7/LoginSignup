package com.pranshu.signup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Just to check whether application is running or not

@RestController
public class Check {
    @GetMapping("/check")
    public String check(){
        return "OK";
    }
}
