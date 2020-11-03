package com.vlados.lab4.main.Cages;

import com.vlados.lab4.main.Animals.Mammals.Lion;

public class LionCage<T extends Lion> extends MammalCage<T> {
    public LionCage(int capacity) {
        super(capacity);
    }
}
