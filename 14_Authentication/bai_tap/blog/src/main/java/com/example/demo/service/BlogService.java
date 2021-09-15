package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAllBlog();
    Optional<Blog> findById(int id);
    List<Blog> findByNameCategory(String nameCategory);
    Page<Blog> findAllBlogPage(Pageable pageable);
}
