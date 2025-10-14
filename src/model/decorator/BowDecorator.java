package model.decorator;

import model.Pet;
import model.state.*;

public class BowDecorator extends PetDecorator {
    private int playsRemains = 3;

    @Override
    public String displayName(Pet pet){
        return "🎀 " + pet.getName();
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
        } else if (pet.getCurrentState() instanceof StateHappy){
            playsRemains--;
            if (playsRemains <= 0) {
                System.out.println(pet.getName() + " brincou demais e perdeu seu lacinho!");
                pet.setAcessory(null);
            } else {
                pet.setHappiness((clamp01(pet.getHappiness() + 5)));
                System.out.println(pet.getName() + " ficou ainda mais feliz por causa do laço");
            }
        }
    }
}
