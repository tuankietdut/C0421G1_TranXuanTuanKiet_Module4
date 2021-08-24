package com.employee.controller;

import com.employee.model.bean.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @ModelAttribute("employee")
    public Employee createEmployee(){
        return new Employee();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showForm(){
        return "employee/create";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model){
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
