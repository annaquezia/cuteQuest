package model.species;

import model.Pet;
import model.PetType;

public class Hamster extends Pet {
    public Hamster(String name) {
        super(name, PetType.HAMSTER);
    }
}
