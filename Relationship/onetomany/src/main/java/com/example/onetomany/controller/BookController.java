package com.example.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.entity.Book;
import com.example.onetomany.service.BookServicve;

@RestController
@RequestMapping("/book")
public class BookController {
    

    @Autowired
    private BookServicve bookService;
    //create

    @PostMapping
    public ResponseEntity<?> doPost(@RequestBody Book book){
        return bookService.addMethod(book);
    }
    
}