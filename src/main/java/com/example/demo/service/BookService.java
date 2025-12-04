package com.example.demo.service;

import com.example.demo.domain.Book;
import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book save(Book book);

    Book detail(Long id);

    Book update(Long id, Book newData);

    void delete(Long id);
}

