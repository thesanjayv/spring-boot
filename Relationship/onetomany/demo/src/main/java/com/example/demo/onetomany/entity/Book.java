package com.example.demo.onetomany.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private Integer bookPrice;
    private Integer bookPublicationYear;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="authorPK")
    private Author author;

    public Book(){}
    
    public Book(String bookName, Integer bookPrice, Integer bookPublicationYear, Author author) {
        this.bookName = bookName;
        this.author = author;
        this.bookPrice = bookPrice;
        this.bookPublicationYear = bookPublicationYear;
    }


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookPublicationYear() {
        return bookPublicationYear;
    }

    public void setBookPublicationYear(int bookPublicationYear) {
        this.bookPublicationYear = bookPublicationYear;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice
                + ", bookPublicationYear=" + bookPublicationYear + "]";
    }


    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }
}
