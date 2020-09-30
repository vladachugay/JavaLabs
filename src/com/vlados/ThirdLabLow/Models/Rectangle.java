package com.vlados.ThirdLabLow.Models;

public class Rectangle extends Shape {
    float sideA;
    float sideB;

    Rectangle(float sideA, float sideB) {
        super("undefined");
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public float calcArea() {
        return sideA * sideB;
    }

    @Override
    public String toString() {
        return "Rectangle: side1 = " + sideA + " side2 = " + sideB;
    }
}
