package com.example.demo.model.service;

import com.example.demo.model.bean.Book;
import com.example.demo.model.bean.CodeBook;
import com.example.demo.model.repository.CodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBookServiceImp implements CodeBookService {
    @Autowired
    CodeBookRepository codeBookRepository;
    @Override
    public void saveCodeBook(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
    }

    @Override
    public CodeBook findByNumberBook(int numberBook) {
        return codeBookRepository.findByNumberBook(numberBook);
    }

    @Override
    public void removeCodeBook(int numberBook) {
        this.codeBookRepository.removeCodeBookByNumberBook(numberBook);
    }
}
