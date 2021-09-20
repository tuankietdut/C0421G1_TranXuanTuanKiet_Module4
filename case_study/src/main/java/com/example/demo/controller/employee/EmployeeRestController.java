package com.example.demo.controller.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> showEdit(@PathVariable int id,
                                             HttpSession session){
        Optional<Employee> employeeOption = this.employeeService.findById(id);
        if (!employeeOption.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        session.setAttribute("string", employeeOption.get().getEmployeeId());
        return new ResponseEntity<>(employeeOption.get(), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Optional<Employee> employeeOption = this.employeeService.findById(id);
        if (!employeeOption.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.employeeService.deleteEmployee(id);
        String result = "Employee: " + employeeOption.get().getEmployeeName() + " deleted";
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
