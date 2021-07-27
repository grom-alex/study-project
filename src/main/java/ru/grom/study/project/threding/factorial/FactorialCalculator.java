package ru.grom.study.project.threding.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FactorialCalculator {

    public void calcFactorial(int factor) throws ExecutionException, InterruptedException {
        long start = System.nanoTime();
        int threadCount = Runtime.getRuntime().availableProcessors();
        int interval = factor / threadCount + 1;
        System.out.println("factor: " + factor + ", interval: " + interval + ", threadCount:" + threadCount);
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        List<Future<BigInteger>> futures = new ArrayList<>();
        int begin = 1;
        int end;
        do {
            end = begin + interval;
            if (end > factor) end = factor;
            int finalBegin = begin;
            int finalEnd = end;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> new FactorialPartCalculator(finalBegin, finalEnd).calc(),
                            threadPool
                    )
            );
            begin = end + 1;
        } while (end < factor);
        BigInteger result = BigInteger.valueOf(1);
        for (Future<BigInteger> future : futures) {
            result = result.multiply(future.get());
        }
        long stop = System.nanoTime();
        System.out.println(String.format("time: %d", ((stop - start)/1000_000)) + ",\tresult: " + result);
        start = System.nanoTime();
        result = new FactorialPartCalculator(1, factor).calc();
        stop = System.nanoTime();
        System.out.println(String.format("time: %d", ((stop - start)/1000_000)) + ",\tresult: " + result );
    }
}
