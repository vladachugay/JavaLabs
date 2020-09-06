package com.vlados.FirstLabLow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    private final String vowelLetters = "aeioyuAEIOYU";
//    public String getString() {
//        System.out.println("Enter words:");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }

    public boolean checkForLatinLetters(String str) {
        str = str.trim();
        for (int j = 0; j < str.length(); j++) {
            // за таблицею ASCII перевряємо, чи входить символ до латинського алфавіту
            if (!((int) str.charAt(j) >= 65 && (int) str.charAt(j) <= 90) &&
                    !((int) str.charAt(j) >= 97 && (int) str.charAt(j) <= 122)) {
                return  false;
            }
            else {
                if (j == str.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForNumOfVowelLetters(String str) {
        str = str.trim();
        int vowelCounter = 0;
        int consonantCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if(vowelLetters.contains(String.valueOf(str.charAt(i)))) vowelCounter++;
             else consonantCounter++;
        }
        if (vowelCounter == consonantCounter) return true;
        else return false;
    }

    public String[] filterWords(String str) {
        List<String> words = new ArrayList<String>(Arrays.asList(str.split(" ")));
        for (int i = 0; i < words.size(); i++) {
            if(!checkForLatinLetters(words.get(i)) || !checkForNumOfVowelLetters(words.get(i))) {
               words.remove(i);
               i--;
            }
        }
        return words.toArray(new String[0]);
    }
}
