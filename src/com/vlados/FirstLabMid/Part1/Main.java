package com.vlados.FirstLabMid.Part1;

public class Main {
    public static void main(String[] args) {
        printPyramid(9);
    }

    public static void printPyramid(int height) {
        if(height > 9 || height < 1) throw new IllegalArgumentException("Argument should be > 0 & < 10");
        else {
            int space = height;
            int num;
            for (int i = 1; i <= height; i++) {
                System.out.format("%"+space+"s", " ");
                num = 1;
                while(num < i) {
                    System.out.print(num);
                    num++;
                }
                while (num >= 1) {
                    System.out.print(num);
                    num--;
                }
                space--;
                System.out.print("\n");
            }
        }


    }
}
