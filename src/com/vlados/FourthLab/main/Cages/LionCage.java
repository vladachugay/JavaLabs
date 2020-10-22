package com.vlados.FourthLab.main.Cages;

import com.vlados.FourthLab.main.Animals.Mammals.Lion;

public class LionCage<T extends Lion> extends MammalCage<T> {
    public LionCage(int capacity) {
        super(capacity);
    }
}
