package com.blog.demo.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String headerContext;
    private String context;
    private String dateBlog;

    public Blog(int id, String headerContext, String context, String dateBlog) {
        this.id = id;
        this.headerContext = headerContext;
        this.context = context;
        this.dateBlog = dateBlog;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeaderContext() {
        return headerContext;
    }

    public void setHeaderContext(String headerContext) {
        this.headerContext = headerContext;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }
}
