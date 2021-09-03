package com.blog.demo.model.repository;

import com.blog.demo.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findBlogByCategory_NameCategory(String nameCategory);
    List<Blog> findAll(Sort sort);
}
