package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kennels")
public class Kennel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private KennelType type;

    @ElementCollection
    @CollectionTable(name = "kennel_pets_ids", joinColumns = @JoinColumn(name = "kennel_id"))
    @Column(name = "pet_id")
    private List<Integer> petsIDs = new ArrayList<>();

    protected Kennel() {}

    public Kennel(String name, int capacity, KennelType type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public boolean addPet(Integer petID) {
        if (petsIDs.size() < capacity && !petsIDs.contains(petID)) {
            petsIDs.add(petID);
            return true;
        }
        return false;
    }

    public boolean removePet(int petID) {
        if (petsIDs.contains(petID)) {
            petsIDs.remove(petID);
        }
        return true;
    }

    public ArrayList<Integer> getPetsIDs() {
        return new ArrayList<>(petsIDs);
    }
// get e set
    public int getKennelID() {
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
