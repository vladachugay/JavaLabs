package com.vlados.lab4.main.Cages;

import com.vlados.lab4.main.Animals.Birds.Bird;

public class BirdCage<T extends Bird> extends Cage<T> {

    public BirdCage(int capacity) {
        super(capacity);
    }
}
