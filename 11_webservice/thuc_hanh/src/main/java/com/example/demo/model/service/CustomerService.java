package com.example.demo.model.service;

import com.example.demo.model.bean.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customers> findAll();

    Optional<Customers> findById(Long id);

    Customers save(Customers customers);

    void remove(Long id);
}
