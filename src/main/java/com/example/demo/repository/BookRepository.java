package com.example.demo.repository;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByViewCntDesc();

    List<Book> findByMemberLoginId(String loginId);
}