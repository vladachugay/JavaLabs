package com.vlados.lab8;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Long> {
    private int [] arr;
    private static final int THRESHOLD = 20;

    public Task(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Long compute() {
        if(arr.length < 20) {
            long sum = 0;
            for (int elem : arr) {
                sum += elem;
            }
            return sum;
        }
        else {
            Task firstHalf = new Task(Arrays.copyOfRange(arr, 0, arr.length/2)); //index "to" is excluded
            firstHalf.fork();
            Task secondHalf = new Task(Arrays.copyOfRange(arr, arr.length/2 , arr.length));
            long resultSecond = secondHalf.compute();
            return firstHalf.join() + resultSecond;
        }
    }
}
