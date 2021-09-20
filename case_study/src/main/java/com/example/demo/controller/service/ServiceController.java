package com.example.demo.controller.service;

import com.example.demo.dto.customer.CustomerDto;
import com.example.demo.dto.service.ServiceDto;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.model.service.Service;
import com.example.demo.model.service.ServiceType;
import com.example.demo.service.service.InterfaceService;
import com.example.demo.service.service.InterfaceServiceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
//@SessionAttributes("string")

public class ServiceController {
    @Autowired
    private InterfaceService interfaceService;
    @Autowired
    private InterfaceServiceType interfaceServiceType;
//
//    @ModelAttribute("service")
//    public ServiceDto inti(){
//        return new ServiceDto();
//    }

    @ModelAttribute("string")
    private String initString(){
        return "";
    }
    @GetMapping
    public ModelAndView listService(@PageableDefault(value = 3) Pageable pageable, @ModelAttribute("service") ServiceDto serviceDto){
        Page<Service> serviceList = this.interfaceService.findAll(pageable);
        List<ServiceType> serviceTypeList = this.interfaceServiceType.findAll();
        ModelAndView modelAndView = new ModelAndView("service/list","serviceTypeList",serviceTypeList );
        modelAndView.addObject("service", serviceDto);
        modelAndView.addObject("serviceList", serviceList);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createService (@Valid @ModelAttribute("service") ServiceDto serviceDto,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                       @PageableDefault(value = 3) Pageable pageable){
        if (bindingResult.hasFieldErrors()){
            return listService(pageable ,serviceDto);
        }
//        if (!string.equals(serviceDto.getServiceId()+"")){
//            ModelAndView modelAndView = new ModelAndView("redirect:/service");
//            redirectAttributes.addFlashAttribute("msg","Dont edit ID bro");
//            return modelAndView;
//        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        this.interfaceService.saveService(service);
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        redirectAttributes.addFlashAttribute("msg","Service: "+ service.getServiceName() + " saved");
        return modelAndView;
    }
}
