package com.vlados.FourthLab.main.Animals;

public abstract class Animal {
    private int id;
    private static int idCounter = 0;

    public Animal() {
        this.idCounter++;
        this.id = idCounter;
    }

    public int getId() {
        return id;
    }
}
