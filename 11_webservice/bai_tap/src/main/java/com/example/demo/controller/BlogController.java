package com.example.demo.controller;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Category;
import com.example.demo.model.service.BlogService;
import com.example.demo.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    //Khoong su dung dto vi bai chi toan phuong thuc get du lieu, ko co put post hoac delete
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

}
