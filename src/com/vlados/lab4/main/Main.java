package com.vlados.lab4.main;

import com.vlados.lab4.main.Animals.Birds.Bird;
import com.vlados.lab4.main.Animals.Birds.Eagle;
import com.vlados.lab4.main.Animals.Mammals.Lion;
import com.vlados.lab4.main.Animals.Mammals.Mammal;
import com.vlados.lab4.main.Animals.Mammals.Ungulates.Giraffe;
import com.vlados.lab4.main.Animals.Mammals.Ungulates.Ungulate;
import com.vlados.lab4.main.Animals.Mammals.Ungulates.Zebra;
import com.vlados.lab4.main.Cages.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        LionCage<Lion> lionCage = new LionCage<>(10);
        lionCage.addAnimal(new Lion());
        lionCage.addAnimal(new Lion());
        lionCage.addAnimal(new Lion());

        Cage<Lion> lionCage1 = new LionCage<>(10);
        lionCage1.addAnimal(new Lion());

        UngulateCage<Ungulate> ungulateCage = new UngulateCage<>(10);
        ungulateCage.addAnimal(new Giraffe());
        ungulateCage.addAnimal(new Giraffe());
        ungulateCage.addAnimal(new Zebra());
        ungulateCage.addAnimal(new Zebra());
        ungulateCage.addAnimal(new Zebra());

        BirdCage<Bird> birdCage = new BirdCage<>(5);
        birdCage.addAnimal(new Eagle());
        birdCage.addAnimal(new Eagle());

        zoo.addCage(lionCage1);
        zoo.addCage(lionCage);
        zoo.addCage(birdCage);
        zoo.addCage(ungulateCage);

        MammalCage<Mammal> mammalCage = new MammalCage<>(3);
        mammalCage.addAnimal(new Giraffe());
        mammalCage.addAnimal(new Zebra());

        Lion myLion = new Lion();
        lionCage.addAnimal(myLion);
        lionCage.removeAnimal(myLion);

        zoo.addCage(new LionCage<>(10));
        System.out.println(zoo.getCountOfAnimals());
        System.out.println(lionCage.getFreePlaces());
        System.out.println(birdCage.getCapacity());
        System.out.println(new Zebra().getId());

    }
}
