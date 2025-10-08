package model;

import java.util.ArrayList;
import java.util.UUID;

public class Kennel {
    private final UUID id = UUID.randomUUID();
    private String name;
    private int capacity;
    private KennelType type;
    private ArrayList<UUID> petsIDs = new ArrayList<>();

    public Kennel(String name, int capacity, KennelType type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public boolean addPet(UUID petID) {
        if (petsIDs.size() < capacity && !petsIDs.contains(petID)) {
            petsIDs.add(petID);
            return true;
        }
        return false;
    }

    public boolean removePet(UUID petID) {
        if (petsIDs.contains(petID)) {
            petsIDs.remove(petID);
        }
        return true;
    }

    public ArrayList<UUID> getPetsIDs() {
        return new ArrayList<>(petsIDs);
    }
// get e set
    public UUID getKennelID() {
        return id;
    }

    public void setKennelName(String name) {
        if (name == null || name.isBlank()) {
            throw  new IllegalArgumentException("Digite o nome da baia");
        }
        this.name = name;
    }

    public String getKennelName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw  new IllegalArgumentException("A capacidade deve ser um número maior que zero");
        }
        this.capacity = capacity;
    }

    public KennelType getType() {
        return type;
    }

    public void setType(KennelType type) {
        this.type = type;
    }

}
