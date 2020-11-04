package com.vlados.lab7hard.main.task_1_1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class AbbreviationBuilder {


    public static String build(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.stream()
                .map(w -> (w != null && w.length() > 1) ? w.substring(0, 1) : "")
                .forEach(sb::append);
        return sb.toString();
    }

}
