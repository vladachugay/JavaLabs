package com.vlados.ThirdLabLow.View;

import com.vlados.ThirdLabLow.Models.Shape;

public class View {
    public static final String ALL_SHAPES = "All shapes:";
    public static final String SUM_AREA = "The sum of the areas of all shapes:";
    public static final String SUM_AREA_CIRCLE = "The sum of the areas of all circles:";
    public static final String SUM_AREA_RECTANGLE = "The sum of the areas of all rectangles:";
    public static final String SUM_AREA_TRIANGLE = "The sum of the areas of all triangles:";
    public static final String COLOR_SORT = "Sorted shapes by color:";
    public static final String AREA_SORT = "Sorted shapes by area:";

    public void showShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
