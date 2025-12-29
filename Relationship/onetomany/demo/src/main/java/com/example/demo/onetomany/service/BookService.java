package com.example.demo.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.onetomany.entity.Author;
import com.example.demo.onetomany.entity.Book;
import com.example.demo.onetomany.repo.AuthorRepo;
import com.example.demo.onetomany.repo.BookRepo;

@Service
public class BookService {

    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    
    public List<Book> create(List<Book> books) {
        for (Book book : books) {
            if (book.getAuthor() != null && book.getAuthor().getAuthorId() != null) {
                Long existingAuthorId = book.getAuthor().getAuthorId();

                Optional<Author> op = authorRepo.findById(existingAuthorId);
                if (op.isPresent()) {
                    book.setAuthor(op.get());
                }
            }
            return bookRepo.saveAll(books);
        }
        return null;
    }


    public List<Book> read() {
        return bookRepo.findAll();
    }

    // public Optional<Book> read(int id){
    //     return bookRepo.findById(id);
    // }
    // public void update(int id, Book book){
    //     Optional<Book> op = bookRepo.findById(id);
    //     if(op.isPresent()){
    //         return bookRepo.save(book);
    //     }
    // }
    // public void delete()
}
