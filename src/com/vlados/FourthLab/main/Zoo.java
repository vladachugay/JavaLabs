package com.vlados.FourthLab.main;

import com.vlados.FourthLab.main.Animals.Animal;
import com.vlados.FourthLab.main.Cages.Cage;
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
