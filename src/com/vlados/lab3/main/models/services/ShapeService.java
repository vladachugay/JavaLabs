package com.vlados.lab3.main.models.services;

import com.vlados.lab3.main.models.comparators.ShapeAreaComparator;
import com.vlados.lab3.main.models.comparators.ShapeColorComparator;
import com.vlados.lab3.main.models.shapes.Shape;
import com.vlados.lab3.main.models.shapes.impl.Circle;
import com.vlados.lab3.main.models.shapes.impl.Rectangle;
import com.vlados.lab3.main.models.shapes.impl.Triangle;

import java.util.ArrayList;
import java.util.List;

public class ShapeService {
    List<Shape> shapes = new ArrayList<>();
    public List<Shape> getShapes() {
        return this.shapes;
    }

    public void autofill() {
       shapes.add(new Circle(20, "Red"));
       shapes.add(new Rectangle(2, 3, "Blue"));
       shapes.add(new Triangle(3,4,5, "Green"));
       shapes.add(new Circle(3.4f, "Pink"));
       shapes.add(new Rectangle(1.4f, 3.67f, "Black"));
       shapes.add(new Triangle(37,37,37, "Orange"));
       shapes.add(new Circle(2, "Brown"));
       shapes.add(new Rectangle(200, 1, "White"));
       shapes.add(new Triangle(4,6,9, "Yellow"));
       shapes.add(new Circle(90, "Gray"));
       shapes.add(new Rectangle(76, 0.4f, "Purple"));
       shapes.add(new Triangle(0.3f,0.49f,0.67f, "Silver"));
       shapes.add(new Circle(0.23f, "Golden"));
       shapes.add(new Rectangle(0.3f, 0.1f, "Violet"));
       shapes.add(new Triangle(38,41,55, "Beige"));

    }

    public float sumAreaForAllShapes() {
        float sumArea = 0;
        for (Shape shape : this.shapes) {
            sumArea += shape.calcArea();
        }
        return sumArea;
    }

    public float sumAreaForSomeShapes(String typeOfShape) {
        float sumArea = 0;
        for (Shape shape : this.shapes) {
            if(shape.getClass().getSimpleName().equals(typeOfShape))
                sumArea += shape.calcArea();
        }
        return  sumArea;
    }

    public void sortByColor(List<Shape> shapes) {
        shapes.sort(new ShapeColorComparator());
    }

    public void sortByArea(List<Shape> shapes) {
        shapes.sort(new ShapeAreaComparator());
    }

    public void addCircle(float radius, String color) {
        shapes.add(new Circle(radius, color));
    }

    public void addTriangle(float sideA, float sideB, float sideC, String color) {
        shapes.add(new Triangle(sideA, sideB, sideC, color));
    }

    public void addRectangle(float sideA, float sideB, String color) {
        shapes.add(new Rectangle(sideA, sideB, color));
    }
}
