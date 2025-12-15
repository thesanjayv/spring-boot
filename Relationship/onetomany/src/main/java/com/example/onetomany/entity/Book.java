package com.example.onetomany.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book { //many
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long book_id;
    private String name;
    

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "theFK")
    private Author author;

    public Book(){}
    public Book(Long book_id, String name, Author author) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
    }
    public Long getBook_id() {
        return book_id;
    }
    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    @Override
    public String toString() {
        return "Book [book_id=" + book_id + ", name=" + name + "]";
    }
}
