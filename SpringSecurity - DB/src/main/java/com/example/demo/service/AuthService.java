package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.example.demo.entity.Auth;
import com.example.demo.repo.CustomUserDetailsRepo;

@Service
public class AuthService {

    @Autowired
    private CustomUserDetailsRepo customUserDetailsRepo;

    public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException{
        Optional<Auth> op = customUserDetailsRepo.findByUserName(userName);
        if(op.isPresent()){
            Auth auth = op.get();
            return User.withUsername(auth.getUserName())
            .password(auth.getPassword())
            .roles(auth.getRole().replace("ROLE_", ""))
            .build();
        } else {
            throw new UsernameNotFoundException("User not found!!");
        }
    }
}