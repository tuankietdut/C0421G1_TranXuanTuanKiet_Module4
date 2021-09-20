package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Optional<Customer> findById(int id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(int id);
    List<Customer> findAll();

}
