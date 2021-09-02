package com.blog.demo.model.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String headerContext;
    private String context;
    private String dateBlog;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
