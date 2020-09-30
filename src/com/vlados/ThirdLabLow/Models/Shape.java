package com.vlados.ThirdLabLow.Models;

public abstract class Shape implements Drawable {
    String shapeColor;

    Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract float calcArea();
    public abstract String toString();
}
