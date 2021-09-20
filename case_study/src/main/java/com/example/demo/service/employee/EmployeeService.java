package com.example.demo.service.employee;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> findAll();

}
