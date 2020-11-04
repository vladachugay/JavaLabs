package com.vlados.lab7hard.main.task_1_2;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class Factorial {


    public static long factorial(long i) {
        return Stream.iterate(1, n -> n + 1).limit(i).reduce((x, y) -> x * y).orElseThrow();
    }
}
