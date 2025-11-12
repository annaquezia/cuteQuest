package model.species;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Pet;
import model.PetType;

@Entity
@DiscriminatorValue("HAMSTER")
public class Hamster extends Pet {
    protected  Hamster() {}
    public Hamster(String name) {
        super(name, PetType.HAMSTER);
    }
}
