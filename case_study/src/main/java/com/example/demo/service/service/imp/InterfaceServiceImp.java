package com.example.demo.service.service.imp;

import com.example.demo.repository.service.ServiceRepository;
import com.example.demo.service.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterfaceServiceImp implements InterfaceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<com.example.demo.model.service.Service> findAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public Optional<com.example.demo.model.service.Service> findById(int id) {
        return this.serviceRepository.findById(id);
    }

    @Override
    public com.example.demo.model.service.Service saveService(com.example.demo.model.service.Service service) {
        return this.serviceRepository.save(service);
    }

    @Override
    public List<com.example.demo.model.service.Service> findAll() {
        return this.serviceRepository.findAll();
    }

    @Override
    public void deleteService(int id) {
        this.serviceRepository.deleteById(id);
    }
}
