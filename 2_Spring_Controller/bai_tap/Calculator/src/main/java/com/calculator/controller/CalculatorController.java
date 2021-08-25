package com.calculator.controller;

import com.calculator.model.service.CalculatorService;
import com.calculator.model.service.CalculatorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequestMapping("")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String menu(){
        return "home";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String selected(@RequestParam(required = false, defaultValue = "0") double firstNumber,@RequestParam(required = false, defaultValue = "0") double secondNumber, String action , Model model){
        switch (action){
            case "plus":
                model.addAttribute("result", calculatorService.plus(firstNumber, secondNumber));
                break;
            case "except":
                model.addAttribute("result", calculatorService.except(firstNumber, secondNumber));
                break;
            case "multiple":
                model.addAttribute("result", calculatorService.multiple(firstNumber, secondNumber));
                break;
            case "divide":
                model.addAttribute("result", calculatorService.divide(firstNumber, secondNumber));
                break;
        }
        return "home";
    }
}
