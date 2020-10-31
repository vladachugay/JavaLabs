package com.vlados.FifthLab.Part3;

import java.io.*;

public class Coder {

    public void encrypt(String text, File file, char key) {
        try(EncodingWriter writer = new EncodingWriter(new FileWriter(file))) {
            for(char c : text.toCharArray()) {
                writer.write((int)c, key);
                System.out.println((int)c);
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
                System.out.println(c);
                sb.append((char)c);
                c = reader.read(key);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return sb.toString();
    }

}

