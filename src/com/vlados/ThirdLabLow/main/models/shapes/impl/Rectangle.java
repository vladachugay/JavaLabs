package com.vlados.ThirdLabLow.main.models.shapes.impl;

import com.vlados.ThirdLabLow.main.models.shapes.Shape;

import java.io.Serializable;
import java.util.Objects;

public class Rectangle extends Shape implements Serializable {
    float sideA;
    float sideB;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.sideA, sideA) == 0 &&
                Float.compare(rectangle.sideB, sideB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    public Rectangle(float sideA, float sideB, String color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(float sideA, float sideB) {
        super("undefined");
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public float calcArea() {
        return sideA * sideB;
    }

    @Override
    public void draw() {
    }
}
