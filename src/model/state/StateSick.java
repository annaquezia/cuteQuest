package model.state;

import model.Pet;

public class StateSick implements PetState {

    @Override
    public void feed(Pet pet) {
        System.out.println(pet.getName() + " está doentinho e não consegue comer até melhorar");
    }

    @Override
    public void play(Pet pet) {
        System.out.println(pet.getName() + " está doentinho e não consegue brincar até melhorar");
    }

    @Override
    public void heal(Pet pet) {
        pet.resetFeedCount();
        pet.resetPlayCount();
        pet.setCurrentState(new StateSleeping());
        System.out.println(pet.getName() + " está se sentindo muito melhor, mas precisa de um cochilo!!");
    }

    @Override
    public void sleep(Pet pet) {
        System.out.println(pet.getName() + " precisa de cuidados antes de ir dormir");
    }

    public void wakeUp(Pet pet) {
        System.out.println(pet.getName() + " já está acordado");
    }

    @Override
    public void tick(Pet pet, int hours) {
        if (hours > 2) {
            pet.setHealth(pet.getHealth() - 10);
            if (pet.getHealth() <= 0) {
                System.out.println(pet.getName() + " não resistiu... (×_×)");
            } else {
                System.out.println(pet.getName() + " está piorando e precisa de cuidados.");
            }
        }
    }

    @Override
    public String getStateName() {
        return "doentinho";
    }

}
