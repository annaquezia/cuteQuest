package model.factory;

import model.Pet;
import model.species.Hamster;
import DAO.KennelDAO;
import DAO.PetDAO;

public class HamsterCreator extends PetCreator{
    public HamsterCreator(PetDAO pets, KennelDAO kennels) {
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName){
        return new Hamster(petName);
    }
}
