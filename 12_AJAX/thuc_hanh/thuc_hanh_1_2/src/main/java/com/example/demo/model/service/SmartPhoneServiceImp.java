package com.example.demo.model.service;

import com.example.demo.model.bean.SmartPhone;
import com.example.demo.model.repository.SmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SmartPhoneServiceImp implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;
    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
