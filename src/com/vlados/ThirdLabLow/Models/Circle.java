package com.vlados.ThirdLabLow.Models;

public class Circle extends Shape{
    float radius;

    Circle(float radius) {
        super("undefined");
        this.radius = radius;
    }


    @Override
    public float calcArea() {
        return (float)(Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle: radius = " + radius ;
    }
}
