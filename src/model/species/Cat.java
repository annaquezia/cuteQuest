package model.species;

import model.Pet;
import model.PetType;

public class Cat extends Pet {
    public Cat(String name) {
        super(name, PetType.CAT);
    }
}
