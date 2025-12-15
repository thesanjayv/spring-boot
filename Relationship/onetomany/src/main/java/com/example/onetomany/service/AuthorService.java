package com.example.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.repo.AuthorRepo;


@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepo authorRepo;

    //create
    public Author addMethod(Author author){
        return authorRepo.save(author);
    }
}