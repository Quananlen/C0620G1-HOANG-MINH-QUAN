package com.giga.service;

import com.giga.entity.Book;
import com.giga.entity.Code;
import com.giga.exception.NotAvailableException;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void borrow(Book book, Integer usedCode);

    void delete(Integer id);

    Code getNextAvailableCode(Book book) throws NotAvailableException;
}
