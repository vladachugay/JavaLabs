package com.vlados.lab3.main.models.shapes.impl;

import com.vlados.lab3.main.models.shapes.Shape;

import java.io.Serializable;
import java.util.Objects;

public class Triangle extends Shape implements Serializable {
    float sideA;
    float sideB;
    float sideC;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.sideA, sideA) == 0 &&
                Float.compare(triangle.sideB, sideB) == 0 &&
                Float.compare(triangle.sideC, sideC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }

    public Triangle(float sideA, float sideB, float sideC, String color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(float sideA, float sideB, float sideC) {
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
    public void draw() {
    }
}
