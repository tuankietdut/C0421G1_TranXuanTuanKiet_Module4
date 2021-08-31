package com.blog.demo.model.service;

import com.blog.demo.model.bean.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    String save(Blog customer);
    String remove(Blog customer);
}
