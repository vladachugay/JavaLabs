package com.vlados.FourthLab.main.Cages;

import com.vlados.FourthLab.main.Animals.Birds.Bird;

public class BirdCage<T extends Bird> extends Cage<T> {

    public BirdCage(int capacity) {
        super(capacity);
    }
}
