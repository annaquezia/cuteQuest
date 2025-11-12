package model.state;

import model.Pet;

public interface PetState {
    void feed(Pet pet);
    void play(Pet pet);
    void heal(Pet pet);
    void sleep(Pet pet);
    void wakeUp(Pet pet);
    void tick(Pet pet, int hours);
    String getStateName();
}
