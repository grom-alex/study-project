package ru.grom.study.project.threding.factorial;

import java.math.BigInteger;

public class FactorialPartCalculator {
    private final int begin;
    private final int end;

    public FactorialPartCalculator(int begin, int end){
        if(begin < 1) begin = 1;
        if(end < begin) end = begin;
        this.begin = begin;
        this.end = end;
    }

    public BigInteger calc(){
        return calcIteratively();
        //return calcRecursively();
    }

    public BigInteger calcIteratively(){
        BigInteger result = BigInteger.valueOf(begin);
        for(long i = begin+1; i <= end; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public BigInteger calcRecursively(){
        return calcRecursively(end);
    }

    private BigInteger calcRecursively(long factor){
        if(factor < begin){
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(factor).multiply(calcRecursively(factor-1));
    }
}
