package com.example.demo.model.service;

import com.example.demo.model.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
}
