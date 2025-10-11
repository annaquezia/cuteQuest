package model.species;

import model.Pet;
import model.PetType;

public class Bunny extends Pet {
    public Bunny(String name) {
        super(name, PetType.BUNNY);
    }
}
