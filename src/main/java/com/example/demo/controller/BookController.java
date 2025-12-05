package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.domain.Likes;
import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // 도서 등록
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book saved = bookService.save(book);
        return ResponseEntity.status(201).body(saved); // 201 Created
    }

    // 도서 목록 조회
    @GetMapping
    public ResponseEntity<List<BookDTO>> list() {
        return ResponseEntity.ok(bookService.findAll());
    }

    // 도서 상세 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> detail(@PathVariable Long bookId) {
        Book book = bookService.detail(bookId);
        return ResponseEntity.ok(book);
    }

    // 도서 수정
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> update(
            @PathVariable Long bookId,
            @RequestBody Book newData) {

        Book updated = bookService.update(bookId, newData);
        return ResponseEntity.ok(updated);
    }

    // 도서 삭제
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    //좋아요 클릭
    @PatchMapping("/{bookId}")
    public ResponseEntity<?> like(@PathVariable Long bookId,@RequestBody Likes like){
        boolean liked =  bookService.likeToggle(bookId, like.getMember().getId());

        if(liked){
            return ResponseEntity.ok("liked");
        }else{
            return ResponseEntity.ok("unliked");
        }

    }
}

