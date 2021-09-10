package com.example.demo.model.service;

import com.example.demo.model.bean.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryService categoryService;
    @Override
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }
}
