package com.vlados.SecondLabMid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private List<Student> students = new ArrayList<>();

    public void run() {
        while (true) {
            showMenu();
            String choice = getUsersLine(); //Функція валідатора
            switch (choice) {
                case "1": addNewRecord();
                case "2": showRecords();
                case "3": return;
            }


        }
    }

    private String getUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void showMenu() {
        System.out.print("Оберіть, що ви хочете зробити:");
        System.out.println("1. Додати запис до журналу куратора.");
        System.out.println("2. Показати всі записи.");
        System.out.println("3. Завершити роботу.");
    }

    private void addNewRecord() {

    }

    private void showRecords() {
        
    }
}
