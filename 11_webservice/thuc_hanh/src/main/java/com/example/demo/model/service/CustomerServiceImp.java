package com.example.demo.model.service;

import com.example.demo.model.bean.Customers;
import com.example.demo.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customers> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customers save(Customers customers) {
        return customerRepository.save(customers);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
