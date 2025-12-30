package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;

public interface  UserRepositary extends JpaRepository<UserEntity, Integer> {
    
    List<UserEntity> findByName (String name);
    
}
