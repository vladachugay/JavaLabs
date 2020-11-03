package com.vlados.lab3.main.view;

import com.vlados.lab3.main.models.shapes.Shape;

import java.util.List;

public class View {
    public static final String ALL_SHAPES = "All shapes:";
    public static final String SUM_AREA = "The sum of the areas of all shapes:";
    public static final String SUM_AREA_CIRCLE = "Amount of area for all circles:";
    public static final String SUM_AREA_RECTANGLE = "Amount of area for all rectangles:";
    public static final String SUM_AREA_TRIANGLE = "Amount of area for all triangles:";
    public static final String COLOR_SORT = "Sorted shapes by color:";
    public static final String AREA_SORT = "Sorted shapes by area:";
    public static final String INVITATION_TO_ENTER_TRIANGLE = "Enter 3 sides of the triangle using enter:";
    public static final String INVITATION_TO_ENTER_CIRCLE = "Enter radius of the circle:";
    public static final String INVITATION_TO_ENTER_RECTANGLE = "Enter 2 sides of the rectangle using enter:";
    public static final String INVITATION_TO_ENTER_COLOR = "Enter color of the shape:";
    public static final String INVITATION_TO_ENTER_TYPE = "Enter type of the shape(circle, rectangle or triangle):";
    public static final String INVITATION_TO_ENTER_FILE_LOCATION = "Enter the file location (path):";
    public static final String INVITATION_TO_ENTER_FILENAME = "Enter the filename:";
    public static final String INCORRECT_FILE = "This file doesn't exist.\n";
    public static final String INCORRECT_INPUT = "Your input is not correct.\n" +
            "Try again:";
    public static final String MAIN_MENU = "Select the option:\n" +
            "1. Add new shape\n" +
            "2. Autofill\n" +
            "3. Show all shapes\n" +
            "4. Calculate amount of area for all shapes\n" +
            "5. Calculate amount of area for some type of shape\n" +
            "6. Sort shapes by area\n" +
            "7. Sort shapes by color\n" +
            "8. Save shapes to file\n" +
            "9. Read shapes from file\n" +
            "10. Exit";

    public void showShapes(List<Shape> shapes) {
        if(shapes.isEmpty()) System.out.println("This list is empty.");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
