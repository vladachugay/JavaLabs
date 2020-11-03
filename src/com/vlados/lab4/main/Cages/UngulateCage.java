package com.vlados.lab4.main.Cages;

import com.vlados.lab4.main.Animals.Mammals.Ungulates.Ungulate;

public class UngulateCage<T extends Ungulate> extends MammalCage<T> {
    public UngulateCage(int capacity) {
        super(capacity);
    }
}
