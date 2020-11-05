package com.vlados.lab7hard.main.task_2_2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class Customer {

    private final String name;
    private final String city;

    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void addOrder(Order anOrder) {
        this.orders.add(anOrder);
    }

    public double getTotalOrderValue() {
        return orders.stream()
                .map(order -> order.getLineItems())
                .flatMap(i -> i.stream())
                .mapToDouble(i -> i.getValue() * i.getQuantity())
                .sum();
    }

    public double getMostExpensiveItemValue() {
        return orders.stream()
                .map(o -> o.getLineItems())
                .flatMap(item -> item.stream())
                .map(i -> i.getValue())
                .max((d1, d2) -> {
                    if(d1 > d2) return 1;
                    if(d2 > d1) return -1;
                    else return 0;
                }).orElseThrow();
    }
}