package com.example.onetomany.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onetomany.entity.Book;
import com.example.onetomany.repo.BookRepo;

@Service
public class BookServicve {
    
    @Autowired
    private BookRepo bookRepo;

    //posting
    @PostMapping
    public ResponseEntity<?> addMethod(Book book){
        if(bookRepo.existsByName(book.getName())){
            return ResponseEntity.badRequest().body("Already exists");
        }
        book = bookRepo.save(book);
        return ResponseEntity.ok(book);
    }
}
