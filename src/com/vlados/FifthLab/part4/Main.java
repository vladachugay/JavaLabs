package com.vlados.FifthLab.part4;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://github.com/vladachugay");
            System.out.println(new Controller().countTags(new IOService().getHTMLFile(url)));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
