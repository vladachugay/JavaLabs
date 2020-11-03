package com.vlados.lab4.main.Cages;

import com.vlados.lab4.main.Animals.Mammals.Mammal;

public class MammalCage<T extends Mammal> extends Cage<T> {

    public MammalCage(int capacity) {
        super(capacity);
    }
}
