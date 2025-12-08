package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService{

    private final BookRepository bookRepository;

    //1. 내가 등록한 도서 불러오기
    @Override
    public List<BookDTO> findRegisteredBook(String loginId){
        List<Book> books = bookRepository.findByMemberLoginId(loginId);

        return books.stream()
                .map(book -> {
                    BookDTO dto = new BookDTO();
                    dto.setBookId(book.getBookId());
                    dto.setTitle(book.getTitle());
                    dto.setAuthor(book.getAuthor());
                    dto.setViewCnt(book.getViewCnt());
                    dto.setImgUrl(book.getImgUrl());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
