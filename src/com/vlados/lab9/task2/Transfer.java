package com.vlados.lab9.task2;

public class Transfer implements Runnable{
    private CircularBuffer from;
    private CircularBuffer to;

    public Transfer(CircularBuffer from, CircularBuffer to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        String str;
        while (true) {
            str = from.get();
            to.add(str);
            System.out.println(Thread.currentThread().getName() + " has transferred string: " + str);
        }
    }
}
