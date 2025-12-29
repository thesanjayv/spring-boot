package com.example.demo.onetomany.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.onetomany.entity.Author;
import com.example.demo.onetomany.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorCon {
    
    private AuthorService authorService;

    public AuthorCon(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping
    public Author create(@RequestBody Author author){
        return authorService.create(author);
    }

    @GetMapping
    public List<Author> read(){
        return authorService.read();
    }

    // @GetMapping
    // public Optional<Book> read(int id){
    //     return authorService.read(id);
    // }
}
