package com.example.demo.controller;

public class OutOfBookException extends Exception {
    public OutOfBookException(String message) {
        super(message);
    }
}
