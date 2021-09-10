package com.example.demo.model.service;

import com.example.demo.model.bean.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAllBlog();
    Optional<Blog> findById(int id);
    List<Blog> findByNameCategory(String nameCategory);
}
