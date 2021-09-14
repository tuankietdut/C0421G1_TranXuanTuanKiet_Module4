package com.example.demo.model.repository;

import com.example.demo.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByCategory_NameCategory(String nameCategory);
}
