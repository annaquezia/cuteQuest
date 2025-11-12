package model.species;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Pet;
import model.PetType;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Pet {
    protected Dog() {}
    public Dog(String name) {
        super(name, PetType.DOG);
    }
}
