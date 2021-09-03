package com.blog.demo.controller;

import com.blog.demo.model.bean.Blog;
import com.blog.demo.model.bean.Category;
import com.blog.demo.model.service.BlogService;
import com.blog.demo.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        List<Category> categoryList =  categoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("blogObject", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView afterCreate(@ModelAttribute Blog blog){
            ModelAndView modelAndView = new ModelAndView("create");
            blog.setDateBlog(new Date(System.currentTimeMillis()));
            this.blogService.save(blog);
            modelAndView.addObject("message","Success create new Blog");
            modelAndView.addObject("blogObject", new Blog());
            return modelAndView;
    }


    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable Integer id){
        Blog blog = this.blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("blogObject", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

//    @PageableDefault (value = 5, sort = "headerContext", direction = Sort.Direction.ASC) Pageable pageable

    @GetMapping("/list")
    public ModelAndView showList(
                                 @SortDefault (sort = "headerContext", direction = Sort.Direction.ASC) Sort sort){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Category> categoryList =  categoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        List<Blog> blogList = this.blogService.findAll(sort);
//        Page<Blog> blogList = this.blogService.pagingBlog(pageable);
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = this.blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            List<Category> categoryList =  categoryService.findAll();
            modelAndView.addObject("categoryList", categoryList);
            modelAndView.addObject("blogObject", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("blogObject") Blog blogObject) {
        this.blogService.save(blogObject);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blogObject", blogObject);
        modelAndView.addObject("message", "blogObject updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Blog blog = this.blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blogObject", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("blogObject") Blog blogObject) {
        this.blogService.remove(blogObject);
        return "redirect:/blog/list";
    }

    @GetMapping("/search")
    public ModelAndView searchByNameCategory(@RequestParam(name = "nameCategory") String name){
        ModelAndView modelAndView = new ModelAndView("search");
        List<Blog> blogList = this.blogService.findByCategoryName(name);
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }
}
