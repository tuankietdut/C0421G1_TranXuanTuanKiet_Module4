package com.email.model.service;

import com.email.model.bean.Email;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImp implements EmailService {

    private Email email;

    {
        email = new Email("English",25, "yes", "Thor King Asgard" );
    }

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public void saveEmail(Email email) {
        this.email = email;
    }
}
