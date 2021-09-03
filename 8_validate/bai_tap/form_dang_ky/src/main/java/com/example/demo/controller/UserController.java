package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/show")
    public ModelAndView showMenu(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
