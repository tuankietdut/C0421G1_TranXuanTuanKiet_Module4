package com.blog.demo.controller;

import com.blog.demo.model.bean.Blog;
import com.blog.demo.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blogObject", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView afterCreate(@ModelAttribute Blog blog){
            ModelAndView modelAndView = new ModelAndView("create");
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

    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", this.blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = this.blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
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


}
