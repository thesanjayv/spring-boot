package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    
    @GetMapping("/public")
    public String home(){
        return "Welcome everyone to home!";        
    }

    @GetMapping("/admin")
    public String contact(){
        return "Welcome ADMIN to home!";        
    }

    @GetMapping("/user")
    public String about(){
        return "Welcome USER to home!";     
    }
}
