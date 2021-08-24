package com.user.controller;

import com.user.model.bean.Login;
import com.user.model.bean.User;
import com.user.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/home")
    public String showMenu(Model model){
        model.addAttribute("login", new Login());
        return "/user/home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){
        User user = UserService.checkLogin(login);
        if(user == null){
            return "/user/error";
        } else {
            model.addAttribute("user", user);
            return "/user/user";
        }
    }
}
