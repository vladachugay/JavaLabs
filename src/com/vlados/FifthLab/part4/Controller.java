package com.vlados.FifthLab.part4;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public Map<String, Integer> countTags(String text) {
        String regex = "<[a-z]{1,}[\\s>]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Map<String, Integer> map = new HashMap<>();
        String tag;
        while (matcher.find()) {
            tag = text.substring(matcher.start() + 1, matcher.end() - 1);
            if (map.containsKey(tag)) map.compute(tag, (key, value) -> ++value);
            else map.put(tag, 1);
        }
        return map;
    }

    
}
