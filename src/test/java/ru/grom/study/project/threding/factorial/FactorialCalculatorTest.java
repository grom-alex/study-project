package ru.grom.study.project.threding.factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void calcFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();
        calculator.calcFactorial(10);
    }
}