package com.example.demo.service;
import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImp implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findByNameCategory(String nameCategory) {
        return this.blogRepository.findAllByCategory_NameCategory(nameCategory);
    }

    @Override
    public Page<Blog> findAllBlogPage(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }
}
