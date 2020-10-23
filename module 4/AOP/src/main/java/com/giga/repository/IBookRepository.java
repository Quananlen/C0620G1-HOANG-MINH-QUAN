package com.giga.repository;

import com.giga.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);
}
