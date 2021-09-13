package com.example.demo.controller;

import com.example.demo.model.bean.SmartPhone;
import com.example.demo.model.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private SmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createPhone(@RequestBody SmartPhone smartPhone){
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/thuc_hanh_2/list");
        modelAndView.addObject("smartphones", this.smartPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<List<SmartPhone>> showList(){
        return new ResponseEntity<>(this.smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = this.smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
