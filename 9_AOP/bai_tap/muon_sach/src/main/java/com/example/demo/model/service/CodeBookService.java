package com.example.demo.model.service;

import com.example.demo.model.bean.Book;
import com.example.demo.model.bean.CodeBook;

public interface CodeBookService {
    void saveCodeBook(CodeBook codeBook);
    CodeBook findByNumberBook(int numberBook);
    void removeCodeBook(int numberBook);
}
