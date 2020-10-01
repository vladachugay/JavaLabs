package com.vlados.ThirdLabLow.Models;

import java.util.Arrays;

public class Service {
    Shape[] shapes = new Shape[15];

    {
       shapes[0] = new Circle(20, "Red");
       shapes[1] = new Rectangle(2, 3, "Blue");
       shapes[2] = new Triangle(3,4,5, "Green");
       shapes[3] = new Circle(3.4f, "Pink");
       shapes[4] = new Rectangle(1.4f, 3.67f, "Black");
       shapes[5] = new Triangle(37,37,37, "Orange");
       shapes[6] = new Circle(2, "Brown");
       shapes[7] = new Rectangle(200, 1, "White");
       shapes[8] = new Triangle(4,6,9, "Yellow");
       shapes[9] = new Circle(90, "Gray");
       shapes[10] = new Rectangle(76, 0.4f, "Purple");
       shapes[11] = new Triangle(0.3f,0.49f,0.67f, "Silver");
       shapes[12] = new Circle(0.23f, "Golden");
       shapes[13] = new Rectangle(0.3f, 0.1f, "Violet");
       shapes[14] = new Triangle(38,41,55, "Beige");

    }
    public Shape[] getShapes() {
        return this.shapes;
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

    public void sortByColor(Shape[] shapes) {
        Arrays.sort(shapes, new ShapeColorComparator());
    }

    public void sortByArea(Shape[] shapes) {
        Arrays.sort(shapes, new ShapeAreaComparator());
    }



}
