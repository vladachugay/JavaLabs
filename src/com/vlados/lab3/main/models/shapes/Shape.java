package com.vlados.lab3.main.models.shapes;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {
    String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public abstract float calcArea();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "  area: " + this.calcArea() + "  color: " + this.getShapeColor();
    }
}
