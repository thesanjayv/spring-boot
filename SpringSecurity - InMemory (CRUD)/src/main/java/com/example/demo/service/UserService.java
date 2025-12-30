package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepositary;

@Service
public class UserService {
    
   
    private UserRepositary userRepo;

    public UserService(UserRepositary userRepo){
        this.userRepo = userRepo;
    }

    //create
    public UserEntity postMethod(UserEntity e){
        return userRepo.save(e);
        // return "Saved";
    }

    //read
    public List<UserEntity> readMethod(){
        return userRepo.findAll();
    }

    public List<UserEntity> readMethod(String name){
        return userRepo.findByName(name);
    }

    //update
    public UserEntity updateMethod(UserEntity e){
        return userRepo.save(e);
    }

    //delete
    public void deleteMethod(Integer e){
        userRepo.deleteById(e);
    }


}
