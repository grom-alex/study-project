package ru.grom.study.project.threding.factorial;

import java.math.BigInteger;

public class FactorialRunnable implements Runnable {

    private final FactorialPartCalculator calculator;
    private BigInteger result;

    public FactorialRunnable(int begin, int end){
        calculator = new FactorialPartCalculator(begin, end);
    }

    @Override
    public void run() {
        result = calculator.calc();
    }

    public BigInteger getResult() {
        return result;
    }

}
