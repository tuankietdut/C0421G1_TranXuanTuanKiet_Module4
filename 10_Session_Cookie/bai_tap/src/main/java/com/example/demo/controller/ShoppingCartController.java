package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }



    @GetMapping("/increase/{id}")
    public ModelAndView increaseProduct(@PathVariable( name = "id") long idProduct, @SessionAttribute("cart") Cart cart){
        Optional<Product> product = productService.findById(idProduct);
        if (!product.isPresent()){
            return new ModelAndView("error404");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/cart/shop");
        cart.pullProduct(product.get());
        return modelAndView;
    }

    @GetMapping("/decrease/{id}")
    public ModelAndView decreaseProduct(@PathVariable( name = "id") long idProduct, @SessionAttribute("cart") Cart cart){
        Optional<Product> product = productService.findById(idProduct);
        if (!product.isPresent()){
            return new ModelAndView("error404");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/cart/shop");
        cart.addProduct(product.get());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable( name = "id") long idProduct, @SessionAttribute("cart") Cart cart){
        Optional<Product> product = productService.findById(idProduct);
        if (!product.isPresent()){
            return new ModelAndView("error404");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/cart/shop");
        cart.getProductMap().remove(product.get());
        return modelAndView;
    }


}
