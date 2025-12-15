package com.example.onetomany.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Author { //one
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long author_id;
    private String name;
    
    @OneToMany(mappedBy="author")
    private List<Book> books;

    public Author(){}
    public Author(Long author_id, String name) {
        this.author_id = author_id;
        this.name = name;
    }
    public Long getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Author [author_id=" + author_id + ", name=" + name + "]";
    }
}
