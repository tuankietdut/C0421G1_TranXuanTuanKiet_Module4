package com.example.demo.service.authen;

import com.example.demo.model.authen.User;

public interface UserService {
    User findByName(String username);
}
