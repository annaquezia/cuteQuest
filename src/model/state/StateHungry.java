package model.state;

import model.Pet;

public class StateHungry implements PetState {

    @Override
    public void feed(Pet pet) {
        if (pet.getHealth() > 75) {
            pet.setCurrentState(new StateHappy());
            System.out.println(pet.getName() + " está feliz novamente!! (─‿‿─)");
        } else if (pet.getHealth() <= 75) {
            pet.setHealth(pet.getHealth() + 15);
            System.out.println(pet.getName() + " comeu e sua saúde melhorou!");
        }
    }

    @Override
    public void play(Pet pet) {
        if (pet.getHealth() > 50) {
            System.out.println(pet.getName() + " está com fome, acho melhor alimentar ele antes de brincar de novo");
            pet.setHappiness(pet.getHappiness() + 20);
            pet.setHealth(pet.getHealth() - 5);
        } else if (pet.getHealth() <= 35) {
            pet.setCurrentState(new StateSick());
            System.out.println(pet.getName() + " está com muita fome e ficou doentinho");
        }
    }

    @Override
    public void heal(Pet pet) {
        System.out.println(pet.getName() + " precisa se alimentar!");
    }

    @Override
    public void sleep(Pet pet) {
        System.out.println(pet.getName() + " precisa comer antes de tirar uma soneca");
    }

    public void wakeUp(Pet pet) {
        System.out.println(pet.getName() + " já está acordado");
    }

    @Override
    public void tick(Pet pet, int hours) {
        if (hours >= 4) {
            pet.setHealth(pet.getHealth() - 10);
            System.out.println(pet.getName() + " está cada vez mais com fome, cuidado para que ele não fique doente");
        }

    }

    public String getStateName() {
        return "faminto";
    }

}
