package model.factory;

import model.Pet;
import model.species.Dog;
import DAO.KennelDAO;
import DAO.PetDAO;

public class DogCreator extends PetCreator {
    public DogCreator(PetDAO pets, KennelDAO kennels) {
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName) {
        return new Dog(petName);
    }
}
