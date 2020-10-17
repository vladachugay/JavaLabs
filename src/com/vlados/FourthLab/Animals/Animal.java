package com.vlados.FourthLab.Animals;

public class Animal {
    private int id;
    private static int counter = 0;

    public Animal() {
        this.counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }
}
