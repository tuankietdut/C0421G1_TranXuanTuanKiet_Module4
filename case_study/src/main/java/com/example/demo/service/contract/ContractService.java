package com.example.demo.service.contract;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Optional<Contract> findById(int id);
    Contract saveContract(Contract contract);
    void deleteContract(int id);
}
