package com.example.demo.dto;

import com.example.demo.model.Category;

import javax.validation.constraints.NotNull;

public class BlogDto {
    @NotNull
    private String headerBlog;
    @NotNull
    private String contentBlog;
    @NotNull
    private Category category;

    public BlogDto() {
    }

    public String getHeaderBlog() {
        return headerBlog;
    }

    public void setHeaderBlog(String headerBlog) {
        this.headerBlog = headerBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
