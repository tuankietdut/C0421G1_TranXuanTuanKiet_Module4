package com.example.demo.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {
    private int count =1;

    @Pointcut("within(com.example.demo.controller.BookController*))")
    public void allMethodOfBook(){};

    @Before("allMethodOfBook()")
    public void beforeMethodWriteLog(){
        System.out.println("Số lần truy cập vào book " + count++);
    }
}
