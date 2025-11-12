package model.factory;

import model.Pet;
import model.species.Cat;
import DAO.KennelDAO;
import DAO.PetDAO;

public class CatCreator extends PetCreator {
    public CatCreator(PetDAO pets, KennelDAO kennels) {
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName) {
        return new Cat(petName);
    }
}
