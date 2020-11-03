package com.vlados.lab4.test;

import com.vlados.lab4.main.Animals.Mammals.Lion;
import com.vlados.lab4.main.Animals.Mammals.Mammal;
import com.vlados.lab4.main.Animals.Mammals.Ungulates.Zebra;
import com.vlados.lab4.main.Cages.LionCage;
import com.vlados.lab4.main.Cages.MammalCage;
import com.vlados.lab4.main.Zoo;
import org.junit.Assert;
import org.junit.Test;

public class ZooTest {

    @Test
    public void testAdd() {
        Zoo zoo = new Zoo();
        LionCage<Lion> lionCage = new LionCage<>(10);
        lionCage.addAnimal(new Lion());
        lionCage.addAnimal(new Lion());
        lionCage.addAnimal(new Lion());
        zoo.addCage(lionCage);

        MammalCage<Mammal> mammalCage = new MammalCage<>(10);
        mammalCage.addAnimal(new Zebra());


        Assert.assertEquals(3, zoo.getCountOfAnimals());
    }

    @Test
    public void testRemove() {
        Zoo zoo = new Zoo();
        LionCage<Lion> lionCage = new LionCage<>(10);
        Lion myLion = new Lion();
        lionCage.addAnimal(myLion);
        lionCage.removeAnimal(myLion);
        zoo.addCage(lionCage);
        Assert.assertEquals(0, zoo.getCountOfAnimals());
    }

    @Test
    public void testGetNumOfAnimals() {
        LionCage<Lion> lionCage = new LionCage<>(10);
        Lion myLion = new Lion();
        lionCage.addAnimal(myLion);
        lionCage.addAnimal(new Lion());
        lionCage.removeAnimal(myLion);
        Assert.assertEquals(1, lionCage.getNumOfAnimals());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveException() {
        LionCage<Lion> lionCage = new LionCage<>(10);
        lionCage.removeAnimal(new Lion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddException() {
        LionCage<Lion> lionCage = new LionCage<>(0);
        lionCage.addAnimal(new Lion());
    }

    @Test
    public void testGetFreePlaces() {
        LionCage<Lion> lionCage = new LionCage<>(10);
        lionCage.addAnimal(new Lion());
        lionCage.addAnimal(new Lion());
        lionCage.addAnimal(new Lion());
        Assert.assertEquals(7, lionCage.getFreePlaces());
    }
}


