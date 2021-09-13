package com.example.demo.model.repository;

import com.example.demo.model.bean.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}
