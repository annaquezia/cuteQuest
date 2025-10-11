package model.factory;

import model.Pet;
import model.species.Hamster;
import repo.KennelRepo;
import repo.PetRepo;

public class HamsterCreator extends PetCreator{
    public HamsterCreator(PetRepo pets, KennelRepo kennels) {
        super(pets, kennels);
    }

    @Override
    public Pet createPet(String petName){
        return new Hamster(petName);
    }
}
