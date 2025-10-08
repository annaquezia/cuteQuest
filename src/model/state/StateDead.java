package model.state;

import model.Pet;

public class StateDead implements PetState {

    public void feed(Pet pet) {
        System.out.println(pet.getName() + " não responde...");
    }

    public void play(Pet pet) {
        System.out.println(pet.getName() + " não responde...");
    }

    public void sleep(Pet pet) {
        System.out.println(pet.getName() + " não responde...");
    }

    public void wakeUp(Pet pet) {
        System.out.println(pet.getName() + " não responde...");
    }

    public void heal(Pet pet) {
        System.out.println(pet.getName() + " não responde...");
    }

    public void tick(Pet pet, int hours) {
        System.out.println(pet.getName() + " não responde...");
    }

    public String getStateName() {
        return "Brincando no céu";
    }

}
