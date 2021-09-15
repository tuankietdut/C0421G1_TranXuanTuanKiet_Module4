package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryService;
    @Override
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }
}
