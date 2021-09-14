package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class I18NController {

    @GetMapping
    public ModelAndView modelAndView (){
        return new ModelAndView("home");
    }

}
