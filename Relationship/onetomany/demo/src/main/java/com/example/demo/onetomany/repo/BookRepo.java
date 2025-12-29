package com.example.demo.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.onetomany.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
