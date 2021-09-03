package com.blog.demo.model.service.Imp;

import com.blog.demo.model.bean.Blog;
import com.blog.demo.model.repository.BlogRepository;
import com.blog.demo.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<Blog> pagingBlog(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByCategoryName(String nameCategory) {
        return this.blogRepository.findBlogByCategory_NameCategory(nameCategory);
    }

    @Override
    public List<Blog> findAll(Sort sort) {
        return this.blogRepository.findAll(sort);
    }
}
