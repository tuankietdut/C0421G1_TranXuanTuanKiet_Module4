package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeDateController {

    @GetMapping("/clock")
    public String homePage(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city, Model model){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long localDate = date.getTime() + (locale.getRawOffset()-local.getRawOffset());
        date.setTime(localDate);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "home";
    }
}
