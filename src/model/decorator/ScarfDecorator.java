package model.decorator;

import model.Pet;
import model.state.*;

public class ScarfDecorator extends PetDecorator {
    private int playsRemains = 2;

    @Override
    public String displayName(Pet pet) {
        return "🧣 " + pet.getName();
    }

    @Override
    public void onPlay(Pet pet) {
        if (pet.getCurrentState() instanceof StateHungry) {
            return;
        } else if (pet.getCurrentState() instanceof StateSick) {
            return;
        } else if (pet.getCurrentState() instanceof StateTired) {
            return;
        } else if (pet.getCurrentState() instanceof StateSleeping) {
            return;
        } else if (pet.getCurrentState() instanceof StateHappy) {
            playsRemains--;
            if (playsRemains <= 0) {
                System.out.println(pet.getName() + " estava sentindo calor e tirou o cachecol!");
                pet.setAcessory(null);
            }
        }
    }

    @Override
    public void onHeal(Pet pet) {
        pet.setCurrentState(new StateHappy());
        pet.resetFeedCount();
        pet.resetPlayCount();
        pet.setHappiness(100);
        pet.setHealth(100);
        System.out.println(pet.getName() + " está se sentindo muito melhor, por causa do cachecol 🧣 não irá precisar dormir");
    }
}
