package com.vlados.lab9.task2;

public class Main {

    public static void main(String[] args) {
        CircularBuffer firstBuffer = new CircularBuffer(10);
        CircularBuffer secondBuffer = new CircularBuffer(10);

        Thread[] producerThreads = new Thread[5];
        Thread[] transferThread = new Thread[2];

        for(Thread t : producerThreads) {
            t = new Thread(new Producer(firstBuffer));
            t.setDaemon(true);
            t.start();
        }

        for(Thread t : transferThread) {
            t = new Thread(new Transfer(firstBuffer, secondBuffer));
            t.setDaemon(true);
            t.start();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println((i + 1) + ". " + secondBuffer.get());
        }
    }
}
