package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main")
@CrossOrigin("*")
public class MainController {

    private final BookService bookService;

    // 인기 도서 (조회수 내림차순)
    @GetMapping("/hot")
    public ResponseEntity<List<BookDTO>> hotBooks() {
        return ResponseEntity.ok(bookService.hotlist());
    }

    // 전체 도서 목록
    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> allBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }
}


