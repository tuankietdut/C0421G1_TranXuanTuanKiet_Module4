package com.blog.demo.model.service;

import com.blog.demo.model.bean.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

}
