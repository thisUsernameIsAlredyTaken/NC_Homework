package com.example.homework.repos;

import com.example.homework.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepos extends JpaRepository<Book, Long> {
}
