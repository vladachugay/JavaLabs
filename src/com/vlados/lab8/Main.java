package com.vlados.lab8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Task().spam();
    }
}

class MyThread extends Thread {

    long time;
    String msg;

    MyThread(String msg, long time) {
        this.time = time;
        this.msg = msg;
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            try {
                sleep(time);
                System.out.println(msg);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                interrupt();
            }
        }
    }
}

class CheckThread extends Thread {
    MyThread[] threads;
    Scanner scanner = new Scanner(System.in);

    CheckThread(MyThread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        while (true) {
            if (scanner.nextLine().toLowerCase().trim().equals("")) {
                for (MyThread thread : threads) {
                    thread.interrupt();
                }
                break;
            }
        }
    }
}



class Task{
    Scanner scanner = new Scanner(System.in);
    MyThread[] threads = new MyThread[3];
    long[] time = new long[threads.length];
    String[] msg = new String[threads.length];

    public void spam() {

        for (int i = 0; i < threads.length; i++) {
            msg[i] = scanner.nextLine();
        }

        for (int i = 0; i < threads.length; i++) {
            time[i] = scanner.nextLong();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(msg[i], time[i]);
            threads[i].start();
        }
        new CheckThread(threads).start();
    }
}

