package com.example.demo.model.repository;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
