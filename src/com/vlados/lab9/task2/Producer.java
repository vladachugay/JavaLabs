package com.vlados.lab9.task2;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    private CircularBuffer buffer;
    private static final char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public Producer(CircularBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String str;
        while (true) {
            try {
                str = generateRandomString();
                buffer.add(str);
                System.out.println(Thread.currentThread().getName() + " has generated string: " + str);
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    private String generateRandomString() {
        int length = (int)(Math.random() * 10);
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
