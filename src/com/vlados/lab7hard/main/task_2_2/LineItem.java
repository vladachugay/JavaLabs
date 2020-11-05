package com.vlados.lab7hard.main.task_2_2;

import java.util.SplittableRandom;
import java.util.function.Function;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class LineItem {

    private String name;
    private final double value;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    public LineItem(String name, double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public LineItem(String name, double value) {
        this(name, value, 1);
    }

    @Override
    public String toString() {
        return this.name + " $" + this.getValue() + " quantity: " + this.quantity +
                " total price: $" + (this.quantity * this.value);
    }
}