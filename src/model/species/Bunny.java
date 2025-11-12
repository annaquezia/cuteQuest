package model.species;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Pet;
import model.PetType;

@Entity
@DiscriminatorValue("BUNNY")
public class Bunny extends Pet {
    protected Bunny() {}
    public Bunny(String name) {
        super(name, PetType.BUNNY);
    }
}
