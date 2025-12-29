package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    
    @GetMapping("/public")
    public String home(){
        return "Welcome everyone to home!";        
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String contact(){
        return "Welcome ADMIN to home!";        
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String about(){
        return "Welcome USER to home!";     
    }
}
