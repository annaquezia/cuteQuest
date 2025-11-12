package model.state;

import model.Pet;

public class StateSleeping implements PetState {

    private int requiredHours = -1;
    private int sleptHours = 0;


    @Override
    public void feed(Pet pet) {
        System.out.println(pet.getName() + " está dormindo!");
    }

    @Override
    public void play(Pet pet) {
        System.out.println(pet.getName() + " está descansando, já já ele acorda para brincar com você!");
    }

    @Override
    public void heal(Pet pet) {
        System.out.println(pet.getName() + " está a mimir");
    }

    @Override
    public void sleep(Pet pet) {
        System.out.println(pet.getName() + " já está dormindo!");
    }

    @Override
    public void wakeUp(Pet pet) {
        if (requiredHours < 0) requiredHours = 1;

        if (sleptHours >= requiredHours) {
            pet.resetFeedCount();
            pet.resetPlayCount();
            pet.setHealth(100);
            pet.setHappiness(100);
            pet.setCurrentState(new StateHappy());
            System.out.println(pet.getName() + " acordou descansado e feliz! (≧◡≦)");
        } else {
            int falta = requiredHours - sleptHours;
            System.out.println(pet.getName() + " ainda precisa dormir mais " + falta + " hora(s)...");
        }
    }

    @Override
    public void tick(Pet pet, int hours) {
        if (hours <= 0) return;

        if (requiredHours < 0) {
            if (pet.getLastState() instanceof StateSick || pet.getHealth() <= 50) {
                requiredHours = 6;
            } else if (pet.getLastState() instanceof StateTired) {
                requiredHours = 4;
            } else {
                if (pet.getHealth() == 100) {
                    requiredHours = 1;
                } else if (pet.getHealth() > 75) {
                    requiredHours = 1;
                } else if (pet.getHealth() > 50) {
                    requiredHours = 2;
                } else {
                    requiredHours = 3;
                }
            }
        }

        sleptHours += hours;

        if (sleptHours >= requiredHours) {
            pet.setCurrentState(new StateHappy());
            pet.setHealth(100);
            pet.setHappiness(100);
            pet.resetFeedCount();
            pet.resetPlayCount();
            System.out.println(pet.getName() + " acordou descansado e feliz! (≧◡≦)");
        } else {
            int remaining = requiredHours - sleptHours;
            System.out.println(pet.getName() + " ainda precisa dormir mais " + remaining + " horas...");
        }
    }


    public String getStateName() {
        return "dormindo";
    }
}
