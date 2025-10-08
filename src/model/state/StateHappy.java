package model.state;

import model.Pet;

public class StateHappy implements PetState {

    public void feed(Pet pet) {
        if (pet.getHealth() == 100) {
            pet.incrementFeedCount();
            if (pet.getFeedCount() > 3) {
                pet.setCurrentState(new StateSick());
                pet.setHealth(45);
                pet.setHappiness(55);
                System.out.println(pet.getName() + " comeu demais e agora está dodoi. (╥﹏╥)");
            } else if (pet.getFeedCount() < 3) {
                System.out.println(pet.getName() + " já comeu o suficiente, se você continuar o alimentar ele pode ficar doente");
            }
        } else {
            pet.setHappiness(pet.getHappiness() + 10);
            pet.setHealth(pet.getHealth() + 20);
            System.out.println(pet.getName() + " comeu e está muito feliz! (⌒∇⌒)");
        }
    }

    public void play(Pet pet) {
        if (pet.getHappiness() == 100) {
            pet.incrementPlayCount();
            if (pet.getPlayCount() > 5) {
                pet.setCurrentState(new StateTired());
                System.out.println(pet.getName() + " brincou demais e agora precisa dormir um pouco");
            } else {
                System.out.println(pet.getName() + " pode ficar cansar se continuar brincando tanto");
            }
        } else if (pet.getHealth() == 75) {
            pet.setCurrentState(new StateHungry());
            pet.setHealth(pet.getHealth() - 5);
            System.out.println(pet.getName() + " está com fome!");
        } else {
            System.out.println(pet.getName() + " amou brincar com você! (♥ω♥ )");
            pet.setHappiness(pet.getHappiness() + 20);
            pet.setHealth(pet.getHealth() - 5);
        }

    }

    public void sleep(Pet pet) {
        pet.setCurrentState(new StateSleeping());
        System.out.println(pet.getName() + " foi mimir. (∪｡∪)｡｡｡zzZ");
    }

    public void wakeUp(Pet pet) {
        System.out.println(pet.getName() + " já está acordado");
    }

    public void heal(Pet pet) {
        System.out.println(pet.getName() + " está bem!! não precisa se preocupar <3");
    }

    public void tick(Pet pet, int hours) {
        if (hours >3) {
            pet.setCurrentState(new StateHungry());
            System.out.println(pet.getName() + " ficou com fome depois de algum tempo");
        }
    }

    public String getStateName() {
        return "feliz";
    }
}
