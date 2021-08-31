package com.example.demo.model.service;

import com.example.demo.model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void remove(Customer customer);
}
