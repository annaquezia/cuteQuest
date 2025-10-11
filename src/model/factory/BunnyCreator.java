package model.factory;

import model.Pet;
import model.species.Bunny;
import repo.KennelRepo;
import repo.PetRepo;

public class BunnyCreator extends PetCreator{
    public BunnyCreator(PetRepo pets, KennelRepo kennels){
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName){
        return new Bunny(petName);
    }
}
