package model.species;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Pet;
import model.PetType;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Pet {
    protected Cat() {}
    public Cat(String name) {
        super(name, PetType.CAT);
    }
}
