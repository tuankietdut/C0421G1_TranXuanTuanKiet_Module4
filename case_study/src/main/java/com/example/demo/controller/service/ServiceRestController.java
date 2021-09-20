package com.example.demo.controller.service;

import com.example.demo.model.service.Service;
import com.example.demo.service.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;
@RestController
public class ServiceRestController {
    @Autowired
    private InterfaceService interfaceService;


    @GetMapping("/service/{id}")
    public ResponseEntity<Service> showEdit(@PathVariable int id,HttpSession session
                                            ){
        Optional<Service> serviceOptional = this.interfaceService.findById(id);
        if (!serviceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
//        string =  + "";
        session.setAttribute("string", serviceOptional.get().getServiceId());
        return new ResponseEntity<>(serviceOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Optional<Service> serviceOptional = this.interfaceService.findById(id);
        if (!serviceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.interfaceService.deleteService(id);
        String result = "Service: " + serviceOptional.get().getServiceName() + " deleted";
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
