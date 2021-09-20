package com.example.demo.service.employee;

import com.example.demo.model.employee.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
}
