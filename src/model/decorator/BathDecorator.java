package model.decorator;

import model.Pet;
import model.state.*;

public class BathDecorator extends PetDecorator {
    private int playsRemains = 5;

    @Override
    public String displayName(Pet pet) {
        return "🛁 " + pet.getName();
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
                System.out.println(pet.getName() + " se sujou brincando e o efeito do banho acabou!");
                pet.setBath(null);
            }
        }
    }

    @Override
    public void onWake(Pet pet) {
        pet.setHappiness((clamp01(pet.getHappiness() + 10)));
        pet.setHealth((clamp01(pet.getHealth() + 5)));
        System.out.println(pet.getName() + " ficou renovado após o banho 🫧. ( 5+ saúde; 10+ felicidade)");
    }

}
