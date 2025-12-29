package com.example.demo.onetomany.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.onetomany.entity.Book;
import com.example.demo.onetomany.service.BookService;

@RestController
@RequestMapping("/book")
public class BookCon {

    private BookService bookService;

    public BookCon(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public List<Book> create(@RequestBody List<Book> book){
        return bookService.create(book);
    }

    @GetMapping
    public List<Book> read(){
        return bookService.read();
    }

    // @GetMapping
    // public Optional<Book> read(int id){
    //     return bookService.read(id);
    // }

    
    // public void update()
    // public void delete()
    
}
