package com.product.controller;

import com.product.model.bean.Product;
import com.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("productList",productService.getList());
        return "home";
    }

    @GetMapping("/create")
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String afterCreate(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        String message = this.productService.createProduct(product);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("product", this.productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String afterEdit(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        String message = this.productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes){
        String message = this.productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/product/list";
    }

    @PostMapping("/search")
    public String search(@RequestParam Optional<String> nameProduct,
                         @RequestParam Optional<Double> priceProductLow,
                         @RequestParam Optional<Double> priceProductBehind,
                         Model model){
        String sql = "select * from product where";
        if (nameProduct.isPresent()){
            sql+= "product_name like %" +nameProduct + "%";
        }
        if (priceProductLow.isPresent()){
            sql += "product_price >" + priceProductLow;
        }
        if (priceProductBehind.isPresent()){
            sql += "product_price <" + priceProductBehind;
        }
        model.addAttribute("productList",productService.findByNameAndPrice(sql));
        return "home";
    }



}
