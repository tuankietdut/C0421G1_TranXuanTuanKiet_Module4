package com.example.demo.service.contract;

import com.example.demo.model.contract.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InterfaceAttachService {
    Page<AttachService> findAll(Pageable pageable);
    Optional<AttachService> findById(int id);
    AttachService saveAttachService(AttachService attachService);
    void deleteAttachService(int id);
}
