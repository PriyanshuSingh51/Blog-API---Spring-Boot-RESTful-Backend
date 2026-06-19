package com.blogapi.blog_api.controller;

import com.blogapi.blog_api.entity.Comment;
import com.blogapi.blog_api.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return service.saveComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return service.getAllComments();
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
        return "Comment Deleted";
    }
}