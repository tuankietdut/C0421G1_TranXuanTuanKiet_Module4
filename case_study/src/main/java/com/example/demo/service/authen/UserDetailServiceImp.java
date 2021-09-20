package com.example.demo.service.authen;

import com.example.demo.model.authen.UserDetailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//@Transactional
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userService.findByName(username)== null){
            throw  new UsernameNotFoundException("Dont have this User " + username);
        }
        return new UserDetailImp(userService.findByName(username));
    }
}
