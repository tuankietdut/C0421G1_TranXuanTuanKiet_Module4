package com.example.demo.controller.contract;

import com.example.demo.dto.contract.AttachServiceDto;
import com.example.demo.dto.contract.ContractDto;
import com.example.demo.dto.customer.CustomerDto;
import com.example.demo.model.contract.AttachService;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.service.Service;
import com.example.demo.service.contract.ContractService;
import com.example.demo.service.contract.InterfaceAttachService;
import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.employee.EmployeeService;
import com.example.demo.service.service.InterfaceService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private InterfaceAttachService attachService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InterfaceService interfaceService;

    @ModelAttribute("contract")
    public ContractDto initContract() {
        return new ContractDto();
    }

    @ModelAttribute("attachService")
    public AttachServiceDto initAttachService() {
        return new AttachServiceDto();
    }

    private List<Object> initParameter(){
        List<Object> result = new ArrayList<>();
        List<Employee> employeeList = this.employeeService.findAll();
        List<Customer> customerList = this.customerService.findAll();
        List<Service> serviceList = this.interfaceService.findAll();
        result.add(employeeList);
        result.add(customerList);
        result.add(serviceList);
        return result;
    }

    @GetMapping
    public ModelAndView listContract(@PageableDefault(value = 3) Pageable pageable,
                                     @ModelAttribute("contract") ContractDto contractDto,
                                     @ModelAttribute("attachService") AttachServiceDto attachServiceDto) {
        Page<Contract> contractList = this.contractService.findAll(pageable);
        List<Object> parameter = initParameter();
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contract", contractDto);
        modelAndView.addObject("attachService", attachServiceDto);
        modelAndView.addObject("contractList", contractList);
        modelAndView.addObject("employeeList", parameter.get(0));
        modelAndView.addObject("customerList", parameter.get(1));
        modelAndView.addObject("serviceList", parameter.get(2));
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView createContract(@Valid @ModelAttribute("contract") ContractDto contractDto,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                       @PageableDefault(value = 3) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            Page<Contract> contractList = this.contractService.findAll(pageable);
            List<Object> parameter = initParameter();
            ModelAndView modelAndView = new ModelAndView("contract/list");
            modelAndView.addObject("contract", contractDto);
            modelAndView.addObject("attachService", new AttachServiceDto());
            modelAndView.addObject("contractList", contractList);
            modelAndView.addObject("employeeList", parameter.get(0));
            modelAndView.addObject("customerList", parameter.get(1));
            modelAndView.addObject("serviceList", parameter.get(2));
            return modelAndView;
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.contractService.saveContract(contract);
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        redirectAttributes.addFlashAttribute("msg", "Contract with ID: " + contract.getContractId() + " saved");
        return modelAndView;
    }

    @PostMapping("/attachService")
    public ModelAndView createAttachService(@Valid @ModelAttribute("attachService") AttachServiceDto attachServiceDto,
                                            BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                            @PageableDefault(value = 3) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            Page<Contract> contractList = this.contractService.findAll(pageable);
            List<Object> parameter = initParameter();
            ModelAndView modelAndView = new ModelAndView("contract/list");
            modelAndView.addObject("contract", new ContractDto());
            modelAndView.addObject("attachService", attachServiceDto);
            modelAndView.addObject("contractList", contractList);
            modelAndView.addObject("employeeList", parameter.get(0));
            modelAndView.addObject("customerList", parameter.get(1));
            modelAndView.addObject("serviceList", parameter.get(2));
            return modelAndView;
        }
        AttachService attachService = new AttachService();
        BeanUtils.copyProperties(attachServiceDto, attachService);
        this.attachService.saveAttachService(attachService);
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        redirectAttributes.addFlashAttribute("msg", "Attach Service: " + attachService.getAttachServiceName() + " saved");
        return modelAndView;
    }

}
