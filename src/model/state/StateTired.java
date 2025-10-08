package model.state;

import model.Pet;

public class StateTired implements PetState {

    @Override
    public void feed(Pet pet) {
        System.out.println(pet.getName() + " está cansado demais e precisa de um cochilo!");
    }

    @Override
    public void play(Pet pet) {
        System.out.println(pet.getName() + " está muito cansadinho e precisa dormir um pouco");
    }

    @Override
    public void heal(Pet pet) {
        System.out.println(pet.getName() + " precisa mimir");
    }

    @Override
    public void sleep(Pet pet) {
        pet.setCurrentState(new StateSleeping());
        System.out.println(pet.getName() + " foi dormir... (＿ ＿*) Z z z");
    }

    public void wakeUp(Pet pet) {
        System.out.println(pet.getName() + " já está acordado");
    }

    @Override
    public void tick(Pet pet, int hours) {
        if (hours >= 2) {
            pet.setHealth(pet.getHealth() - 10);
            if (pet.getHealth() <= 0) {
                System.out.println(pet.getName() + " não aguentou e desmaiou... (x . x) ~~zzZ");
                pet.setCurrentState(new StateSleeping());
            } else {
                System.out.println(pet.getName() + " precisa mesmo ir dormir");
            }
        }

    }

    public String getStateName() {
        return "cansado";
    }
}
