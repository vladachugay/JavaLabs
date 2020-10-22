package com.vlados.FourthLab.main.Cages;

import com.vlados.FourthLab.main.Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Animal> {
    private final int capacity;

    private final List<T> animals = new ArrayList<>();

    public Cage(int capacity) {
        this.capacity = capacity;
    }

    public int getNumOfAnimals() {
        return this.animals.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreePlaces() {
        return capacity - animals.size();
    }

    public void addAnimal(T animal) {
        if (capacity == animals.size()) throw new IllegalArgumentException();
        animals.add(animal);
    }

    public void removeAnimal(T animal) {
        if (!animals.remove(animal)) throw new IllegalArgumentException();
    }
}

