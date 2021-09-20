package com.example.demo.service.contract.imp;

import com.example.demo.model.contract.AttachService;
import com.example.demo.repository.contract.AttachServiceRepository;
import com.example.demo.service.contract.InterfaceAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AttachServiceImp implements InterfaceAttachService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return this.attachServiceRepository.findAll(pageable);
    }

    @Override
    public Optional<AttachService> findById(int id) {
        return this.attachServiceRepository.findById(id);
    }

    @Override
    public AttachService saveAttachService(AttachService attachService) {
        return this.attachServiceRepository.save(attachService);
    }

    @Override
    public void deleteAttachService(int id) {
        this.attachServiceRepository.deleteById(id);
    }
}
