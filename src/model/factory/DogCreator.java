package model.factory;

import model.Pet;
import model.species.Dog;
import repo.KennelRepo;
import repo.PetRepo;

public class DogCreator extends PetCreator {
    public DogCreator(PetRepo pets, KennelRepo kennels) {
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName) {
        return new Dog(petName);
    }
}
