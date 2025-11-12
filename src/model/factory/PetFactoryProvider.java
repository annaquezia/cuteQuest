package model.factory;

import model.PetType;
import DAO.KennelDAO;
import DAO.PetDAO;

public class PetFactoryProvider {
    private PetFactoryProvider() {}

    public static PetCreator forType(PetType petType, PetDAO petDAO, KennelDAO kennelDAO) {
        switch (petType) {
            case DOG:
                return new DogCreator(petDAO, kennelDAO);
            case CAT:
                return new CatCreator(petDAO, kennelDAO);
            case BUNNY:
                return new BunnyCreator(petDAO, kennelDAO);
            case HAMSTER:
                return new HamsterCreator(petDAO, kennelDAO);
            default: throw new IllegalArgumentException("Tipo inválido: " + petType);
        }
    }
}
