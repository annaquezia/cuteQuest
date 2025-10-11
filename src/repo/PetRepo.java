package repo;

import java.util.*;
import model.Pet;

public class PetRepo {
    private final Map<UUID, Pet> pets = new LinkedHashMap<>();

    public void addPet(Pet pet) {
        Objects.requireNonNull(pet, "Pet não pode ser nulo.");
        pets.put(pet.getId(), pet);
    }

    public boolean removePet(UUID id) {
        return pets.remove(id) != null;
    }

    public Optional<Pet> getAllPet(UUID id) {
        return Optional.ofNullable(pets.get(id));
    }

    public List<Pet> getKennelPets(UUID id) {
        List<Pet> kennelPets = new ArrayList<>();
        for (Pet pet : pets.values()) {
            if (Objects.equals(pet.getKennelID(), id)) {
                kennelPets.add(pet);
            }
        }
        return kennelPets;
    }

    public List<Pet> getAllPets() {
        List<Pet> allPets = new ArrayList<>();
        for (Pet pet : pets.values()) {
            allPets.add(pet);
        }
        return allPets;
    }
}
