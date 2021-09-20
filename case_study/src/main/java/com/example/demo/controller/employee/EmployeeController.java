package com.example.demo.controller.employee;

import com.example.demo.dto.employee.EmployeeDto;
import com.example.demo.model.employee.Division;
import com.example.demo.model.employee.Education;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import com.example.demo.service.employee.DivisionService;
import com.example.demo.service.employee.EducationService;
import com.example.demo.service.employee.EmployeeService;
import com.example.demo.service.employee.PositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationService educationService;

    @ModelAttribute("employee")
    public EmployeeDto init(){
        return new EmployeeDto();
    }
    @GetMapping
    public ModelAndView listEmployee(@PageableDefault(value = 3) Pageable pageable, @ModelAttribute EmployeeDto employeeDto){
        Page<Employee> employeeList = this.employeeService.findAll(pageable);
        List<Division> divisions = this.divisionService.findAll();
        List<Education> educations = this.educationService.findAll();
        List<Position> positions = this.positionService.findAll();
        ModelAndView modelAndView = new ModelAndView("employee/list","positionList",positions );
        modelAndView.addObject("educationList", educations);
        modelAndView.addObject("divisionList", divisions);
        modelAndView.addObject("employee", employeeDto);
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                       @PageableDefault(value = 3) Pageable pageable){
        if (bindingResult.hasFieldErrors()){
            return listEmployee(pageable ,employeeDto);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.saveEmployee(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        redirectAttributes.addFlashAttribute("msg","Employee: "+ employee.getEmployeeName() + " saved");
        return modelAndView;
    }
}
