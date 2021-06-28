package ru.grom.study.project.threding.factorial;

import java.math.BigInteger;

public class FactorialRunnable implements Runnable {

    private final int begin;
    private final int end;
    private BigInteger result;

    public FactorialRunnable(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        result = calc(end);
    }

    public BigInteger getResult() {
        return result;
    }

    private BigInteger calc(long factor){
        if(factor < begin){
            return BigInteger.valueOf(begin);
        }
        return BigInteger.valueOf(factor).multiply(calc(factor-1));
    }
}
