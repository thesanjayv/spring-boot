package com.example.demo.onetomany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.onetomany.entity.Author;
import com.example.demo.onetomany.repo.AuthorRepo;

@Service
public class AuthorService {
    
    public AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
        
    }

    public Author create(Author author){
        return authorRepo.save(author);
    }

    public List<Author> read(){
        return authorRepo.findAll();
    }
    // public void read()
    // public void update()
    // public void delete()
}
