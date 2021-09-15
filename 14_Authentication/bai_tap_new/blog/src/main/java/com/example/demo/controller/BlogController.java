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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public ModelAndView homePage(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("homeView","blogList", this.blogService.findAllBlogPage(pageable));
    }

    @GetMapping("/manage")
    public ModelAndView showManage(){
        return new ModelAndView("manage");
    }

    @GetMapping("/view")
    public ModelAndView showView(){
        return new ModelAndView("view");
    }

    @GetMapping("/403")
    public ModelAndView show403(){
        return new ModelAndView("403");
    }

}
