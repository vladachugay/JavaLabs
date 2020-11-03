package com.vlados.lab5.part3.main;

import java.io.*;

public class Coder {

    public void encrypt(String text, File file, char key) {
        try(EncodingWriter writer = new EncodingWriter(new FileWriter(file))) {
            for(char c : text.toCharArray()) {
                writer.write(c, key);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String decrypt(File file, char key) {
        StringBuilder sb = new StringBuilder();
        int c;
        try(EncodingReader reader = new EncodingReader(new FileReader(file))) {
            c = reader.read(key);
            while (c + (int)key != -1) {
                sb.append((char)c);
                c = reader.read(key);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return sb.toString();
    }

}

