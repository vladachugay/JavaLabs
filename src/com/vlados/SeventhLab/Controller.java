package com.vlados.SeventhLab;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Controller {

    public String lambda(String str) {

        return Stream.of(str.split(" ")).min(Comparator.comparingInt(s -> Stream.of(s.split(""))
                .collect(Collectors.toSet()).size())).orElseThrow();
    }
}
