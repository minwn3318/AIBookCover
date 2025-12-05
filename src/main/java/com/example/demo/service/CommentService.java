package com.example.demo.service;

import com.example.demo.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Long bookId , Comment comment);

    List<Comment> getComments(Long bookId);

    Comment updateComment(Long commentId , Comment newData);

    void deleteComment(Long commentId);
}
