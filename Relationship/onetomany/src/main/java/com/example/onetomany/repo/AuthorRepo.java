package com.example.onetomany.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{
    
}
