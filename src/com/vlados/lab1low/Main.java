package com.vlados.lab1low;

import java.util.Arrays;

public class Main {

    //3.	Знайти ті слова, які містять тільки символи латинського алфавіту.
    // Серед них знайти ті слова, які містять рівну кількість голосних та приголосних.
    // На вхід поступає рядок із словами. На виході – масив String.
    public static void main(String[] args) {
    Task task = new Task();
    System.out.println(Arrays.toString(task.filterWords("I love my husband  ооти ьоткрbdgvi")));

    }
}
