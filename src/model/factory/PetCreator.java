package model.factory;

import model.Kennel;
import model.KennelType;
import model.Pet;
import model.PetType;
import model.state.StateHappy;
import DAO.KennelDAO;
import DAO.PetDAO;

public abstract class PetCreator {
    protected final PetDAO pets;
    protected final KennelDAO kennels;

    protected PetCreator(PetDAO pets, KennelDAO kennels) {
        this.pets = pets;
        this.kennels = kennels;
    }

    protected abstract Pet createPet(String name);

    public Pet newPet(String name) {
        Pet pet = createPet(name);
        pet.setCurrentState(new StateHappy());
        pet.setHappiness(100);
        pet.setHealth(100);
        createPetAutoKennel(pet);
        pets.addPet(pet);
        return pet;
    }

    protected void createPetAutoKennel(Pet pet) {
        KennelType required = kennelTypeFor(pet.getType());

        Kennel kennel = kennels.findKennelWithSpaceByType(required).orElseGet(() -> {
            String newName = defaultKennelName(required, kennels);
            Kennel k = new Kennel(newName, 5, required);
            kennels.addKennel(k);
            return k;
        });

        if (kennel.addPet(pet.getId())) {
            pet.setKennelID(kennel.getKennelID());
        }
    }

    private static KennelType kennelTypeFor(PetType type) {
        switch (type) {
            case DOG:    return KennelType.DOG;
            case CAT:    return KennelType.CAT;
            case BUNNY: return KennelType.BUNNY;
            case HAMSTER: return KennelType.HAMSTER;
            default:     return KennelType.HOSPITAL; // fallback seguro
        }
    }

    private static String defaultKennelName(KennelType type, KennelDAO repo) {
        long idx = repo.countByKennelType(type) + 1;
        return type.getDisplayName() + " #" + idx;
    }

}
