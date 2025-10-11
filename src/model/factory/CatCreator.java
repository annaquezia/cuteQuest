package model.factory;

import model.Pet;
import model.species.Cat;
import repo.KennelRepo;
import repo.PetRepo;

public class CatCreator extends PetCreator {
    public CatCreator(PetRepo pets, KennelRepo kennels) {
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName) {
        return new Cat(petName);
    }
}
