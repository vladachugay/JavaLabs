package com.vlados.SixthLab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();

    {
        dictionary.put("i", "я");
        dictionary.put("love", "любити");
        dictionary.put("walk", "ходити");
        dictionary.put("you", "ти");
        dictionary.put("we", "ми");
    }

    public void addWord(String engWord, String ukrWord) {
        dictionary.put(engWord.toLowerCase(), ukrWord.toLowerCase());
    }

    public String translate(String engText) {
        return Arrays.stream(engText.split(" "))
                .map(w -> dictionary.containsKey(w) ? dictionary.get(w) : w)
                .collect(Collectors.joining(" "));
    }
}
