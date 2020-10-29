package com.vlados.FifthLab.Part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static final IOService ioService = new IOService();

    public void  run() {
        List<String> lines = new ArrayList<>();
        boolean isPathCorrect = false;
        while(!isPathCorrect) {
            try {
                lines = ioService.getLines(getPath());
            }
            catch (IOException exception) {
                System.err.println("Помилка при зчитуванні файлу: " + exception.getMessage());
                System.err.println("Спробуйте ще раз");
                continue;
            }
            isPathCorrect = true;
        }
        if(!lines.isEmpty()) {
            System.out.println("Рядок з максимальною кількістю слів:");
            System.out.println(findMaxSentence(lines));
        }
        else System.out.println("Файл пустий.");
    }



    private String getUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    private String getPath() {
        System.out.println("Введіть шлях до файлу у форматі \"path\\filename.txt\" або його назву, " +
                "якщо він знаходиться у директорії програми:");
        return getUsersLine();
    }

    private String findMaxSentence(List<String> lines) {
        int maxLength = 0;
        int index = 0;
        for (String line: lines) {
            if(line.split(" ").length > maxLength) {
                maxLength = line.split(" ").length;
                index = lines.indexOf(line);
            }
        }
        return lines.get(index);
    }


}
