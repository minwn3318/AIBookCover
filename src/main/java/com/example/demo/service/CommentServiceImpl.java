package com.example.demo.service;


import com.example.demo.domain.Book;
import com.example.demo.domain.Comment;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Comment addComment(Long bookId , Comment comment) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("책을 찾을 수 없습니다 . bookId= " + bookId));

        comment.setBook(book);
        comment.setRegTime(LocalDate.now());
        comment.setUpdateTime(null);

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long bookId) {
        return commentRepository.findByBook_BookId(bookId);
    }

    @Override
    @Transactional
    public Comment updateComment(Long commentId, Comment newData) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다 . commentId= " + commentId));

        comment.setContent(newData.getContent());
        comment.setAuthor(newData.getAuthor());
        comment.setUpdateTime(LocalDate.now());

        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
