package com.email.model.service;

import com.email.model.bean.Email;

public interface EmailService {
    public Email getEmail();
    public void saveEmail(Email email);
}
