package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.bean.User;
import com.example.demo.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/show")
    public ModelAndView showMenu(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userObject", new UserDto());
        return modelAndView;
    }

    @PostMapping("/show")
    public ModelAndView signUser(@Valid @ModelAttribute("userObject") UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.userService.saveUser(user);

        ModelAndView modelAndView = new ModelAndView("complete");
        modelAndView.addObject("message","Success");
        return modelAndView;
    }

}
