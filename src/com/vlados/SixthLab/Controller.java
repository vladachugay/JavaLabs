package com.vlados.SixthLab;

import java.util.Scanner;

public class Controller {
    static Scanner scanner = new Scanner(System.in);
    static Dictionary dictionary = new Dictionary();

    public void run() {
        Dictionary dictionary = new Dictionary();
        while(true) {
            System.out.println("\n1. Translate\n" +
                    "2. Add new word\n" +
                    "3. Exit\n");
            switch (scanner.nextLine()) {
                case "1" -> this.translate();
                case "2" -> this.addNewWord();
                case "3" -> System.exit(1);
                default -> System.out.println("Incorrect input.\n");
            }
        }
    }

    private void translate() {
        String text;
        while(true) {
            System.out.println("Enter word/sentence in English:");
            text = scanner.nextLine();
            if(text.trim().isEmpty()) {
                System.out.println("Error: empty string. Try again.");
                continue;
            }
            System.out.println(dictionary.translate(text));
            break;
        }
    }

    private void addNewWord() {
        String eng;
        String ukr;
        while (true) {
            try {
                System.out.println("Enter the word you want to add in English:");
                if((eng = scanner.nextLine().trim()).isEmpty()) throw new IllegalArgumentException();
                System.out.println("Enter translation:");
                if((ukr = scanner.nextLine().trim()).isEmpty()) throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: empty string. Try again.");
                continue;
            }
        }
        dictionary.addWord(eng, ukr);
        System.out.println("Done!");
    }
}
