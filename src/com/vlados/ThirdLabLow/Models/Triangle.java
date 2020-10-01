package com.vlados.ThirdLabLow.Models;

public class Triangle extends Shape{
    float sideA;
    float sideB;
    float sideC;

    Triangle(float sideA, float sideB, float sideC, String color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    Triangle(float sideA, float sideB, float sideC) {
        super("undefined");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public float calcArea() {
        float p = (sideA + sideB + sideC)/2;
        return (float)Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));

    }

    @Override
    public String toString() {
        return "Triangle (Area = " + this.calcArea() + "):  side1 = " +
                sideA + "  side2 = " + sideB + "  side3 = " + sideC;

    }
}
