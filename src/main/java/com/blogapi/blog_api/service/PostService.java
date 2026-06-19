package com.blogapi.blog_api.service;

import com.blogapi.blog_api.entity.Post;
import com.blogapi.blog_api.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post updatePost(Long id, Post post) {
        post.setId(id);
        return repository.save(post);
    }

    public void deletePost(Long id) {
        repository.deleteById(id);
    }
}