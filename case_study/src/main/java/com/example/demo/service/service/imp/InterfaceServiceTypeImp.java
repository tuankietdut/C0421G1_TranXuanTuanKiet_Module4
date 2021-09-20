package com.example.demo.service.service.imp;
import com.example.demo.model.service.ServiceType;
import com.example.demo.repository.service.ServiceTypeRepository;
import com.example.demo.service.service.InterfaceServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterfaceServiceTypeImp implements InterfaceServiceType {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeRepository.findAll();
    }
}
