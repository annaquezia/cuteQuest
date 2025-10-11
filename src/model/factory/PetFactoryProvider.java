package model.factory;

import model.PetType;
import repo.KennelRepo;
import repo.PetRepo;

public class PetFactoryProvider {
    private PetFactoryProvider() {}

    public static PetCreator forType(PetType petType, PetRepo petRepo, KennelRepo kennelRepo) {
        switch (petType) {
            case DOG:
                return new DogCreator(petRepo, kennelRepo);
            case CAT:
                return new CatCreator(petRepo, kennelRepo);
            case BUNNY:
                return new BunnyCreator(petRepo, kennelRepo);
            case HAMSTER:
                return new HamsterCreator(petRepo, kennelRepo);
            default: throw new IllegalArgumentException("Tipo inválido: " + petType);
        }
    }
}
