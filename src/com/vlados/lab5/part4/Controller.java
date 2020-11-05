package com.vlados.lab5.part4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Controller {

    public void run() {
        Map<String, Integer> map;
        while(true) {
            try {
                map = this.countTags(new IOService().getHTMLFile(this.retrieveURL()));
                System.out.println("result: \n" + map);
                break;
            } catch (IOException exception) {
                System.out.println("Some exception occurred. " + exception.toString());
                System.out.println("Try again.");
            }
        }
        while (true) {
            System.out.println("\n1. Sort by quantity.\n" +
                    "2. Sort by name\n" +
                    "3. Exit");
            switch (this.retrieveUsersLine().trim()) {
                case "1" -> this.sortByQuantity(map);
                case "2" -> this.sortByName(map);
                case "3" -> System.exit(1);
                default -> System.out.println("Incorrect input.\n");
            }
        }
    }

    public String retrieveUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public URL retrieveURL() {
        URL url;
        while(true) {
            try {
                System.out.println("Enter URL:");
                url = new URL(this.retrieveUsersLine());
                break;
            } catch (MalformedURLException e) {
                System.out.println("Incorrect input: " + e.getMessage());
                System.out.println("Try again.");
            }
        }
        return url;
    }

    public Map<String, Integer> countTags(String text) {
        String regex = "<[a-z]+[\\s>]";
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

    public void sortByName(Map<String, Integer> unsortedMap) {

        Map<String, Integer> result = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (item1, item2) -> item1, LinkedHashMap::new));
        System.out.println(result);
    }

    public void sortByQuantity(Map<String, Integer> unsortedMap) {
        Map<String, Integer> result = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (item1, item2) -> item1, LinkedHashMap::new));
        System.out.println(result);
    }
}
