package com.email.controller;

import com.email.model.bean.Email;
import com.email.model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("")
    public String showEdit(Model model){
        String[] language = { "English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("language",language);
        int[] pageSize = {5,10,15,25,50,100};
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("email", emailService.getEmail());
        return "home";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        this.emailService.saveEmail(email);
        redirectAttributes.addFlashAttribute("msg","Done Edit");
        return "edit";
    }
}
