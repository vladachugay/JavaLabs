package com.vlados.FourthLab.main.Cages;

import com.vlados.FourthLab.main.Animals.Mammals.Ungulates.Ungulate;

public class UngulateCage<T extends Ungulate> extends MammalCage<T> {
    public UngulateCage(int capacity) {
        super(capacity);
    }
}
