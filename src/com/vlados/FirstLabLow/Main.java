package com.vlados.FirstLabLow;

import java.util.Arrays;

public class Main {

    //3.	Знайти ті слова, які містять тільки символи латинського алфавіту.
    // Серед них знайти ті слова, які містять рівну кількість голосних та приголосних.
    // На вхід поступає рядок із словами. На виході – масив String.
    public static void main(String[] args) {
    Task task = new Task();
    System.out.println(Arrays.toString(task.filterwords("I love my husband  ооти ьоткрbdgvi")));

    }
}
