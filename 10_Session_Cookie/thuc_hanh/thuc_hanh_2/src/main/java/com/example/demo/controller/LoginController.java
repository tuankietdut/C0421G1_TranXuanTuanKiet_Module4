package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User initUser(){
        return new User();
    }

//    public String showLogin( Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser) {
////        Cookie[] cookies = request.getCookies();
////        for (Cookie ck : cookies){
////            if (ck.getName().equals("setUser")){
////                model.addAttribute("cookieValue", ck);
////            }
////            if (ck.getName().equals("setPassword")){
////                model.addAttribute("cookiePass", ck);
////            }
////        }
//        model.addAttribute("cookieValue", setUser);
//        return "/login";
//    }

//    @PostMapping("/dologin")
//    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
//                          HttpServletResponse response, HttpServletRequest request) {
//        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
////            if (user.getEmail() != null)
//                setUser = user.getEmail();
//
//            // create cookie and set it in response
//            Cookie cookie = new Cookie("setUser", setUser);
//            cookie.setMaxAge(24 * 60 * 60);
//            response.addCookie(cookie);
//
//            //get all cookies
//            Cookie[] cookies = request.getCookies();
//            //iterate each cookie
//            for (Cookie ck : cookies) {
//                //display only the cookie with the name 'setUser'
//                if (ck.getName().equals("setUser")) {
//                    model.addAttribute("cookieValue", ck);
//                    break;
//                } else {
//                    ck.setValue("");
//                    model.addAttribute("cookieValue", ck);
//                    break;
//                }
//            }
//            model.addAttribute("message", "Login success. Welcome ");
//        } else {
//            user.setEmail("");
//            Cookie cookie = new Cookie("setUser", setUser);
//            model.addAttribute("cookieValue", cookie);
//            model.addAttribute("message", "Login failed. Try again.");
//        }
//        return "/login";
//    }
    @RequestMapping("/login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser,
                        @CookieValue(value = "setPass", defaultValue = "") String passWord,
                        Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        Cookie cookiePass = new Cookie("setPass", passWord);
        model.addAttribute("cookieValue", cookie);
        model.addAttribute("cookieValue2", cookiePass);
        return "/login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                           @CookieValue(value = "setPass", defaultValue = "") String  passWord,HttpServletResponse response) {
        if ("admin@gmail.com".equals(user.getEmail()) && "12345".equals(user.getPassword())){
                setUser = user.getEmail();
                passWord = user.getPassword();

            Cookie cookie = new Cookie("setUser", setUser);
            Cookie cookiePass = new Cookie("setPass", passWord);
            cookiePass.setMaxAge(24 * 60 * 60);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookiePass);
            response.addCookie(cookie);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("cookieValue2", cookiePass);
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
    }

