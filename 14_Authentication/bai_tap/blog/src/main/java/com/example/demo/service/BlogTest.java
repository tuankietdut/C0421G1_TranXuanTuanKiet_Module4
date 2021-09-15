package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class BlogTest implements BlogService {
    private BlogRe
    @Override
    public List<Blog> findAllBlog() {
        return null;
    }

    @Override
    public Optional<Blog> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Blog> findByNameCategory(String nameCategory) {
        return null;
    }

    @Override
    public Page<Blog> findAllBlogPage(Pageable pageable) {
        return null;
    }
}
