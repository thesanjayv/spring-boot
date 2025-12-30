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

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String contact(){
        return "Welcome ADMIN to home!";        
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String about(){
        return "Welcome USER to home!";     
    }
}
