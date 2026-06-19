package com.blogapi.blog_api.service;

import com.blogapi.blog_api.entity.Comment;
import com.blogapi.blog_api.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment saveComment(Comment comment) {
        return repository.save(comment);
    }

    public List<Comment> getAllComments() {
        return repository.findAll();
    }

    public void deleteComment(Long id) {
        repository.deleteById(id);
    }
}