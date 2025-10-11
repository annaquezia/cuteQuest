package model.species;

import model.Pet;
import model.PetType;

public class Dog extends Pet {

    public Dog(String name) {
        super(name, PetType.DOG);
    }
}
