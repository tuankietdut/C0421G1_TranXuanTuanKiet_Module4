package com.example.demo.service.employee.imp;

import com.example.demo.model.employee.Position;
import com.example.demo.repository.employee.PositionRepository;
import com.example.demo.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImp implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
