package com.blog.demo.model.service;

import com.blog.demo.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    String save(Blog customer);
    String remove(Blog customer);
    Page<Blog> pagingBlog (Pageable pageable);
    List<Blog> findByCategoryName(String nameCategory);
    List<Blog> findAll(Sort sort);
}
