package model.decorator;

import model.Pet;
import model.state.StateHappy;
import model.state.StateSleeping;

public class ScarfDecorator extends PetDecorator {

    @Override
    public String displayName(Pet pet) {
        return "🧣 " + pet.getName();
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
