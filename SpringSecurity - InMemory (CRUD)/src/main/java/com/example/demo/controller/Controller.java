package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class Controller {
    
    @Autowired
    private UserService userServivce;

    @GetMapping("/public")
    public String publicMethod(){
        return "Welcome to everyone!!";
    }
    
    //create
    @PostMapping("/postusers")
    public UserEntity postMethod(@RequestBody UserEntity e){
        return userServivce.postMethod(e);
    }

    //read
    @GetMapping("/getusers")
    public List<UserEntity> getMethod(){
        return userServivce.readMethod();
    }

    @GetMapping("/postusers/{name}")
    public List<UserEntity> getMethod(@PathVariable String name){
        return userServivce.readMethod(name);
    }

    //update
    @PutMapping("/postusers/edit")
    public UserEntity updateMethod(UserEntity e){
        return userServivce.updateMethod(e);
    }

    //delete
    @DeleteMapping("/postusers/{id}")
    public String deleteMethod(@PathVariable("id") Integer e){
        userServivce.deleteMethod(e);
        return "Done";

    }

    
    
}
