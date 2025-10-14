package model.decorator;

import model.Pet;
import model.state.*;
import ui.UiScene;

public class ScarfDecorator extends PetDecorator {

    public ScarfDecorator(Pet pet) {
        super(pet);
    }

    private int playsRemains = 2;

    @Override
    public String displayName(Pet pet) {
        return "🧣 " + pet.getName();
    }

    @Override
    public void play(Pet pet) {
        if (pet.getCurrentState() instanceof StateHungry
                || pet.getCurrentState() instanceof StateSick
                || pet.getCurrentState() instanceof StateTired
                || pet.getCurrentState() instanceof StateSleeping) {
            super.play(pet);
            return;
        }

        super.play(pet);
        if (pet.getCurrentState() instanceof StateHappy) {
            playsRemains--;
            if (playsRemains <= 0) {
                System.out.println(pet.getName() + " estava sentindo calor e tirou o cachecol!");
                pet.setAcessory(null);
            }
        }
    }

    @Override
    public void heal(Pet pet) {
        pet.setCurrentState(new StateHappy());
        pet.resetFeedCount();
        pet.resetPlayCount();
        pet.setHappiness(100);
        pet.setHealth(100);
        System.out.println(pet.getName() + " está se sentindo muito melhor, por causa do cachecol 🧣 não irá precisar dormir");
    }
}
