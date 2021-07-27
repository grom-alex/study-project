package ru.grom.study.project.threding.factorial;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void calcFactorial() throws ExecutionException, InterruptedException {
        FactorialCalculator calculator = new FactorialCalculator();
        calculator.calcFactorial(10000);
    }
}