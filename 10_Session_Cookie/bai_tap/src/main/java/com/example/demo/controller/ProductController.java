package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart initCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("productList",productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public ModelAndView addProductToCart(@PathVariable(name = "id")Long idProduct, @SessionAttribute("cart") Cart cart, RedirectAttributes redirectAttributes){
        Optional<Product> product = productService.findById(idProduct);
        if (!product.isPresent()){
            return new ModelAndView("error404");
        }
        cart.addProduct(product.get());
        redirectAttributes.addFlashAttribute("msg", product.get().getName() +" đã thêm vào giỏ hàng ~~");
        return new ModelAndView("redirect:/shop");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable(name = "id")Long idProduct){
        Optional<Product> product = productService.findById(idProduct);
        if (product.isPresent()){
            ModelAndView modelAndView = new ModelAndView("detail");
            modelAndView.addObject("productObject", product.get());
            return modelAndView;
        }
        return new ModelAndView("error404");
    }




}
