package com.vlados.lab7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {

    public String find(String str) {

        return Stream.of(str.split(" ")).min(Comparator.comparingInt(s -> Stream.of(s.split(""))
                .collect(Collectors.toSet()).size())).orElseThrow();
    }
}
