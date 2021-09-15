package com.example.demo.controller;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Category;
import com.example.demo.model.service.BlogService;
import com.example.demo.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogRestController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogs = this.blogService.findAllBlog();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = this.categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable("id") int idBlog){
        Optional<Blog> blogOptional = this.blogService.findById(idBlog);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findBlogById(@RequestParam String nameCategory){
        List<Blog> blogList = this.blogService.findByNameCategory(nameCategory);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/nextPage")
    public ResponseEntity<Page<Blog>> showMoreBlog(@PageableDefault(value = 2) Pageable pageable){
        Page<Blog> blogs = this.blogService.findAllBlogPage(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(blogs, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
