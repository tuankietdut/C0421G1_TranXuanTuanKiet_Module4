package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidateEmail {
    private final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("")
    public String homePage(){
        return "home";
    }

    @PostMapping("/validate")
    public String regexMail(@RequestParam("email") String email, Model model){
        if (email.matches(EMAIL_REGEX)){
            model.addAttribute("message", email);
            return "success";
        }

        model.addAttribute("message","Email is invalid");
        return "home";
    }


}
