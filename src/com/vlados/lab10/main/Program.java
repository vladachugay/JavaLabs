package com.vlados.lab10.main;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Enter the string you want to change:");
        String string = scanner.nextLine();
        System.out.println("Enter the substitution:");
        String substitution = scanner.nextLine();
        System.out.println("Start string: " + string);
        changeString(string, substitution);
        System.out.println("Changed string: " + string);

        // заємо рядок черз строковий літерал
        System.out.println("\n\n\n\nUsing string literal");
        String str = "str";
        System.out.println("Start string: " + str);
        changeString(str, "value");
        System.out.println("Changed string: " + str);
    }

    public void changeString(String str, String substitution) {
        try {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(str, substitution.getBytes());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
