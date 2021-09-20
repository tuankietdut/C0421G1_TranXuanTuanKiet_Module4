package com.example.demo.service.contract.imp;

import com.example.demo.model.contract.Contract;
import com.example.demo.repository.contract.ContractRepository;
import com.example.demo.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImp implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.contractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return this.contractRepository.findById(id);
    }

    @Override
    public Contract saveContract(Contract contract) {
        return this.contractRepository.save(contract);
    }

    @Override
    public void deleteContract(int id) {
        this.contractRepository.deleteById(id);
    }
}
