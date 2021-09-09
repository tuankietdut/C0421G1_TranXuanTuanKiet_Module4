package com.example.demo.controller;

import com.example.demo.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("counter")
@RequestMapping("/count")
public class ViewController {
    @Autowired
    private HttpSession httpSession;

    @ModelAttribute("counter")
    public View initView(){
        return new View();
    }

    @GetMapping("")
    public ModelAndView get(@SessionAttribute(value = "counter") View counter) {
        counter.increment();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("counter", counter);
        return modelAndView;
    }

    @GetMapping("/test")
    public ModelAndView showSession(){
        return new ModelAndView("test");
    }
}
