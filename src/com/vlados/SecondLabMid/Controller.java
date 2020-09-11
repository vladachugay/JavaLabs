package com.vlados.SecondLabMid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    Validator validator = new Validator();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private List<Student> students = new ArrayList<>();

    public void run() {
        while (true) {
            showMenu();
            String choice = getUsersLine();
            if(validator.checkChoice(choice)) {
                switch (choice) {
                    case "1":
                        addNewRecord();
                        break;
                    case "2":
                        showRecords();
                        break;
                    case "3": return;
                }

            }
            else {
                System.out.println("Помилка! Пункт меню вибраний невірно. Спробуйте ще.");
            }
        }
    }

    private String getUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    private void showMenu() {
        System.out.println("Оберіть, що ви хочете зробити:");
        System.out.println("1. Додати запис до журналу куратора.");
        System.out.println("2. Показати всі записи.");
        System.out.println("3. Завершити роботу.");
    }

    private void addNewRecord() {
        try {
            students.add(new Student(getSurnameFromUser(),getNameFromUser(), getDateFromUser(), getTelNumFromUser(),
                    getStreetFromUser(), getBuildingFromUser(), getFlatFromUser()));
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!");
        }


    }

    private void showRecords() {
        if (students.isEmpty()) System.out.println("В журналі немає жодних записів.");
        else {
            for (Student student: students) {
                System.out.println("Прізвище: " + student.getSurname());
                System.out.println("Ім'я: " + student.getName());
                System.out.println("Дата народження" + formatter.format(student.getDateOfBirth()));
                System.out.println("Адреса: вулиця " + student.getStreet());                          // Пробл з адресою (nested static class)
            }
        }
    }

    private String getSurnameFromUser() {
        while (true) {
            System.out.println("Введіть прізвище студента: ");
            String surname = getUsersLine();
            if(validator.checkString(surname)) {
                return surname;
            }
            System.out.println("Помилка! Введено пустий рядок. Спробуйте ще.");
        }
    }

    private String getNameFromUser() {
        while (true) {
            System.out.println("Введіть ім'я студента: ");
            String name = getUsersLine();
            if(validator.checkString(name)) {
                return name;
            }
            System.out.println("Помилка! Введено пустий рядок. Спробуйте ще.");
        }
    }

    private Date getDateFromUser() {
        while (true) {
            System.out.println("Введіть дату народження студента у форматі \"02-05-2016\": ");
            Date date = validator.checkDate(getUsersLine());
            if(date != null) {
                return date;
            }
            System.out.println("Помилка! Невірний формат введення. Спробуйте ще.");
        }
    }

    private String getTelNumFromUser() {
        String telNum;
        while (true) {
            System.out.println("Введіть номер телефону студента у форматі \"380...\"");
            telNum = getUsersLine();
            if(Pattern.matches("380\\d{9}", telNum)) {
                return telNum;
            }
            System.out.println("Помилка! Невірний формат введення. Спробуйте ще.");
        }
    }

    private String getStreetFromUser() {
        String street;
        while (true) {
            System.out.println("Введіть адресу студента. Вулиця: ");
            street = getUsersLine();
            if(validator.checkString(street)) {
                return street;
            }
            System.out.println("Помилка! Введено пустий рядок. Спробуйте ще.");
        }
    }

    private int getBuildingFromUser() {
        int building;
        while (true) {
            System.out.println("Будинок: ");
            building = validator.checkNumber(getUsersLine());
            if(building!= 0) {
                return building;
            }
            System.out.println("Помилка! Невірний формат введення. Спробуйте ще.");
        }
    }

    private int getFlatFromUser() {
        int flat;
        while (true) {
            System.out.println("Квартира: ");
            flat = validator.checkNumber(getUsersLine());
            if(flat!= 0) {
                return flat;
            }
            System.out.println("Помилка! Невірний формат введення. Спробуйте ще.");
        }
    }









}
