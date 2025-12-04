package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        book.setRegDate(LocalDate.now());
        book.setUpdateDate(LocalDate.now());
        return bookRepository.save(book);
    }

    @Override
    public Book detail(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("책을 찾지 못했습니다."));
    }

    @Override
    public Book update(Long id, Book newData) {
        Book book = detail(id);

        book.setTitle(newData.getTitle());
        book.setContent(newData.getContent());
        book.setAuthor(newData.getAuthor());
        book.setUpdateDate(LocalDate.now());

        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}

