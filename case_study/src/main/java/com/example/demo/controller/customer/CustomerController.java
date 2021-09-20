package com.example.demo.controller.customer;

import com.example.demo.dto.customer.CustomerDto;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.customer.CustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("customer")
    public CustomerDto inti(){
        return new CustomerDto();
    }
    @GetMapping
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable, @ModelAttribute CustomerDto customerDto){
        Page<Customer> customerList = this.customerService.findAll(pageable);
        List<CustomerType> customerTypes = this.customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/list","customerTypeList",customerTypes );
        modelAndView.addObject("customer", customerDto);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createCustomer (@Valid @ModelAttribute("customer") CustomerDto customerDto,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                       @PageableDefault(value = 3) Pageable pageable){
        if (bindingResult.hasFieldErrors()){
            return listCustomer(pageable ,customerDto);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        redirectAttributes.addFlashAttribute("msg","Customer: "+ customer.getCustomerName() + " saved");
        return modelAndView;
    }
}
