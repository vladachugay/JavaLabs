package com.vlados.lab1low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    private final String VOWEL_LETTERS = "aeioyuAEIOYU";

    public boolean checkForLatinLetters(String str) {
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            // за таблицею ASCII перевряємо, чи входить символ до латинського алфавіту
            if (!((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90) &&
                    !((int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122)) return false;
        }
        return true;
    }

    public boolean checkForNumOfVowelLetters(String str) {
        str = str.trim();
        int vowelCounter = 0;
        int consonantCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if(VOWEL_LETTERS.contains(String.valueOf(str.charAt(i)))) vowelCounter++;
             else consonantCounter++;
        }
        return vowelCounter == consonantCounter;
    }

    public String[] filterWords(String str) {
        List<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
        for (int i = 0; i < words.size(); i++) {
            if(!checkForLatinLetters(words.get(i)) || !checkForNumOfVowelLetters(words.get(i))) {
               words.remove(i);
               i--;
            }
        }
        return words.toArray(new String[0]);
    }
}
