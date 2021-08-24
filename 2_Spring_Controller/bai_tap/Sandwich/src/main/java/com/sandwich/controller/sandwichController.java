package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sandwich")
public class sandwichController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String menu(){
        return "home";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String selected(@RequestParam(required = false) String lettuce, String tomato, String mustard, String sprouts, Model model){
        model.addAttribute("lettuce", lettuce);
        model.addAttribute("tomato", tomato);
        model.addAttribute("mustard", mustard);
        model.addAttribute("sprouts", sprouts);
        return "view";
    }
}
