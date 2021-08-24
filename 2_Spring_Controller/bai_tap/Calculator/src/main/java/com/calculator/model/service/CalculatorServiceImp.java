package com.calculator.model.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class CalculatorServiceImp implements CalculatorService {
    @Override
    public double plus(double firstNumber, double secondNumber) {
        return firstNumber+secondNumber;
    }

    @Override
    public double except(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double multiple(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) return 0;
        return firstNumber/secondNumber;
    }
}
