package com.example.demo.service.employee.imp;

import com.example.demo.model.employee.Division;
import com.example.demo.repository.employee.DivisionRepository;
import com.example.demo.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImp implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
