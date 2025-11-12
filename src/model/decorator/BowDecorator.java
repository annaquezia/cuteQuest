package model.decorator;

import model.Pet;
import model.state.*;

public class BowDecorator extends PetDecorator {

    public BowDecorator(Pet pet) {
        super(pet);
    }

    private int playsRemains = 3;

    @Override
    public String displayName(Pet pet){
        return "🎀 " + pet.getName();
    }

    @Override
    public void play(Pet pet) {
        if (pet.getCurrentState() instanceof StateHungry
                || pet.getCurrentState() instanceof StateSick
                || pet.getCurrentState() instanceof StateTired
                || pet.getCurrentState() instanceof StateSleeping) {
            return;
        }

        playsRemains--;
        if (pet.getCurrentState() instanceof StateHappy){
            if (playsRemains <= 0) {
                System.out.println(pet.getName() + " brincou demais e perdeu seu lacinho!");
                pet.setAcessory(null);
            } else {
                pet.setHappiness((clamp(pet.getHappiness() + 5)));
                System.out.println(pet.getName() + " ficou ainda mais feliz por causa do laço");
            }
        }
    }

}
