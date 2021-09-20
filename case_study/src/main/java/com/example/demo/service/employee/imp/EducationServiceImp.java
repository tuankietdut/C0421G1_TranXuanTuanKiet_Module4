package com.example.demo.service.employee.imp;

import com.example.demo.model.employee.Education;
import com.example.demo.repository.employee.EducationRepository;
import com.example.demo.service.employee.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImp implements EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
