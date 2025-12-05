package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("/{bookId}")
    public Comment addComment(
            @PathVariable Long bookId,
            @RequestBody Comment comment
    ) {
        return commentService.addComment(bookId, comment);
    }

    // 댓글 목록 조회
    @GetMapping("/{bookId}")
    public List<Comment> getComments(@PathVariable Long bookId) {
        return commentService.getComments(bookId);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public Comment updateComment(
            @PathVariable Long commentId,
            @RequestBody Comment comment
    ) {
        return commentService.updateComment(commentId, comment);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}