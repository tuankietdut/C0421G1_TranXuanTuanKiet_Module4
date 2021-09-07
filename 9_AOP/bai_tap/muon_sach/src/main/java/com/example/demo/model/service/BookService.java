package com.example.demo.model.service;

import com.example.demo.model.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void saveBook(Book book);
    Book findById(int id);
    void updateBook(int quantity, int id);
}
