package model.decorator;

import model.Pet;

public interface PetComponent {

    void feed(Pet pet);
    void play(Pet pet);
    void sleep(Pet pet);
    void wakeUp(Pet pet);
    void heal(Pet pet);
    void tick(Pet pet, int hours);

    String getName();
    void setName(String name);

    int getHealth();
    void setHealth(int health);

    int getHappiness();
    void setHappiness(int happiness);

    default String displayName() {
        return getName();
    }
}
