package com.vlados.FourthLab.Cages;

public class Cage {
    private int id;
    static private int counter;

    public Cage() {
        counter++;
        this.id = counter;
    }
}
