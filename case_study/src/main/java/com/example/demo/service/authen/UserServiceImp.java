package com.example.demo.service.authen;

import com.example.demo.model.authen.User;
import com.example.demo.repository.authen.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByName(String username) {
        return this.userRepository.findById(username).get();
    }
}
