package com.vlados.ThirdLabLow.Models;

public class Service {
    Shape[] shapes = new Shape[15];

    public void fillShapes() {

    }

//    public void showShapes() {
//        for (int i = 0; i < shapes.length; i++) {
//            System.out.println(shapes[i].toString());
//        }
//    }

    public float sumArea() {
        float sumArea = 0;
        for (Shape shape : shapes) {
            sumArea += shape.calcArea();
        }
        return sumArea;
    }
}
