package com.blog.demo.model.service.Imp;

import com.blog.demo.model.bean.Category;
import com.blog.demo.model.repository.CategoryRepository;
import com.blog.demo.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
