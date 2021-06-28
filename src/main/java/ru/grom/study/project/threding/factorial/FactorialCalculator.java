package ru.grom.study.project.threding.factorial;

public class FactorialCalculator {

    public void calcFactorial(int factor) {
        FactorialRunnable task = new FactorialRunnable(1, factor);
        Thread thr = new Thread(task);
        thr.start();
        try {
            thr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(task.getResult());
    }
}
