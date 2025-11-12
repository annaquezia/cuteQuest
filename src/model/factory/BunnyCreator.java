package model.factory;

import model.Pet;
import model.species.Bunny;
import DAO.KennelDAO;
import DAO.PetDAO;

public class BunnyCreator extends PetCreator{
    public BunnyCreator(PetDAO pets, KennelDAO kennels){
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName){
        return new Bunny(petName);
    }
}
