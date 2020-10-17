package com.vlados.ThirdLabLow.Models.Comparators;

import com.vlados.ThirdLabLow.Models.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if(shape1.calcArea() > shape2.calcArea()) return 1;
        if(shape1.calcArea() < shape2.calcArea()) return -1;
        return 0;
    }
}
