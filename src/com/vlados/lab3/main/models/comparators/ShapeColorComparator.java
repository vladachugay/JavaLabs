package com.vlados.lab3.main.models.comparators;

import com.vlados.lab3.main.models.shapes.Shape;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return shape1.getShapeColor().length() - shape2.getShapeColor().length();
    }
}
