package com.blog.demo.model.service;

import com.blog.demo.model.bean.Blog;
import com.blog.demo.model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public String save(Blog blog) {
        this.blogRepository.save(blog);
        return "success";
    }

    @Override
    public String remove(Blog blog) {
        this.blogRepository.delete(blog);
        return "success";
    }
}
