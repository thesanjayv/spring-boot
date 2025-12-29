package com.example.demo.onetomany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long authorId;
    private String authorName;
    
    @OneToMany(mappedBy="author", cascade=CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
    
    public Author(){}
    public Author(String authorName, List<Book> books) {
        this.books = books;
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
