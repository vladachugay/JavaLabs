package com.vlados.FourthLab.main.Cages;

import com.vlados.FourthLab.main.Animals.Mammals.Mammal;

public class MammalCage<T extends Mammal> extends Cage<T> {

    public MammalCage(int capacity) {
        super(capacity);
    }
}
