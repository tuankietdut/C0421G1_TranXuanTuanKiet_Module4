package com.example.demo.service.service;

import com.example.demo.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface InterfaceService {
    Page<Service> findAll(Pageable pageable);
    Optional<Service> findById(int id);
    Service saveService(Service service);
    void deleteService(int id);
    List<Service> findAll();

}
