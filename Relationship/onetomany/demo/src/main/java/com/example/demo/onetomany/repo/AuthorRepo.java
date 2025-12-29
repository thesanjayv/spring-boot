package com.example.demo.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.onetomany.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
