package com.example.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.entity.Author;
import com.example.onetomany.service.AuthorService;



@RestController
@RequestMapping("/author")
public class AuthorController {
    

    @Autowired
    private AuthorService authorService;
    //create

    @PostMapping
    public Author doPost(@RequestBody Author author){
        return authorService.addMethod(author);
    }
}
