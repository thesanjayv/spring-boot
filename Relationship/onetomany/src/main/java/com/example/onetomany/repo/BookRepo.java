package com.example.onetomany.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
    boolean existsByName(String name);   
}
