package com.vlados.ThirdLabLow.main.models.shapes.impl;

import com.vlados.ThirdLabLow.main.models.shapes.Shape;

import java.io.Serializable;
import java.util.Objects;

public class Circle extends Shape implements Serializable {
    float radius;

    public Circle(float radius, String color) {
        super(color);
        this.radius = radius;
    }

    public Circle(float radius) {
        super("undefined");
        this.radius = radius;
    }

    @Override
    public float calcArea() {
        return (float)(Math.PI * radius * radius);
    }

    @Override
    public void draw() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Float.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
