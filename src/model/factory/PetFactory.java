package model.factory;

import model.Kennel;
import model.KennelType;
import model.Pet;
import model.PetType;
import model.state.StateHappy;
import repo.KennelRepo;

import java.util.Objects;

public class PetFactory {

    public static Pet createPet(String name, PetType petType) {
        Pet pet = new Pet(name, petType);
        pet.setCurrentState(new StateHappy());
        pet.setHealth(100);
        pet.setHappiness(100);
        pet.setAdopted(false);
        return pet;
    }

    public static Pet createPetAutoKennel(String name, PetType petType, KennelRepo kennelRepo, int defaultCapacity) {
        Objects.requireNonNull(kennelRepo, "kennelRepo can't be null");
        Pet pet = new Pet(name, petType);

        KennelType required = kennelTypeFor(petType);

        Kennel kennel = kennelRepo.findKennelWithSpaceByType(required).orElseGet(() -> {
            String newName = defaultKennelName(required, kennelRepo);
            Kennel k = new Kennel(newName, defaultCapacity, required);
            kennelRepo.addKennel(k);
            return k;
        });

        if (kennel.addPet(pet.getId())) {
            pet.setKennelID(kennel.getKennelID());
        }
        return pet;
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

    private static String defaultKennelName(KennelType type, repo.KennelRepo repo) {
        long idx = repo.countByKennelType(type) + 1;
        return type.getDisplayName() + " #" + idx;
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("name não pode ser vazio");
    }
}

