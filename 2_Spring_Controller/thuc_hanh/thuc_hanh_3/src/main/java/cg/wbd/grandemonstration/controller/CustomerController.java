package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customers/{id}")
    public String showDetail(@PathVariable long id, Model model){
        model.addAttribute("customer", customerService.findOne(id));
        return "customers/info";
    }

    @PostMapping("customers")
    public String saveCustomer(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String address){
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        return "redirect:/customers";
    }

}


