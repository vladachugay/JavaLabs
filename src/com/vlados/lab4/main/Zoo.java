package com.vlados.lab4.main;

import com.vlados.lab4.main.Animals.Animal;
import com.vlados.lab4.main.Cages.Cage;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Cage<? extends Animal>> cages = new ArrayList<>();
    public int getCountOfAnimals (){
        int count = 0;
        for (Cage<? extends Animal> cage: cages) {
            count += cage.getNumOfAnimals();
        }
        return count;
    }

    public void addCage(Cage<? extends Animal> cage){
        cages.add(cage);
    }

}
