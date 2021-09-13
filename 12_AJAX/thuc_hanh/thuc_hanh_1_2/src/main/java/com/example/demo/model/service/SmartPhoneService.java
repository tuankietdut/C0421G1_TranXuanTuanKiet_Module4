package com.example.demo.model.service;

import com.example.demo.model.bean.SmartPhone;

import java.util.List;
import java.util.Optional;

public interface SmartPhoneService {
    List<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
