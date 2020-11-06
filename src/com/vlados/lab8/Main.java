package com.vlados.lab8;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int [] arr = new int[1_000_000];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        long startForkJoin = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        long forkJoinResult = forkJoinPool.invoke(new Task(arr));

        long endForkJoin = System.currentTimeMillis();
        long timeForkJoin = endForkJoin - startForkJoin;

        long startOneThread = System.currentTimeMillis();

        long oneThreadResult = 0;
        for (int j : arr) {
            oneThreadResult += j;
        }

        long endOneThread = System.currentTimeMillis();
        long timeOneThread = endOneThread - startOneThread;

        System.out.println("One thread result: " + oneThreadResult + "\t\ttime = " + timeOneThread);
        System.out.println("ForkJoin result: " + forkJoinResult + "\t\ttime = " + timeForkJoin);
    }
}



