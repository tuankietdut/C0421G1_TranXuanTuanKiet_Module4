package com.example.demo.controller;

import com.example.demo.model.bean.Customers;
import com.example.demo.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomer(){
        List<Customers> customersList = customerService.findAll();
        if (customersList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> findById(@PathVariable("id") long idCustomer){
        Optional<Customers> customers = this.customerService.findById(idCustomer);
        if (!customers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers){
        return new ResponseEntity<>(this.customerService.save(customers), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable("id") long idCustomer, @RequestBody Customers customers){
        Optional<Customers> customersOptional = this.customerService.findById(idCustomer);
        if (!customersOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customers.setId(customersOptional.get().getId());
        return new ResponseEntity<>(this.customerService.save(customers), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable("id") long idCustomer){
        Optional<Customers> customers = this.customerService.findById(idCustomer);
        if (!customers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerService.remove(idCustomer);
        return new ResponseEntity<>( customers.get(), HttpStatus.OK);
    }
}
