package model.decorator;

import model.Pet;
import model.state.*;

public class BathDecorator extends PetDecorator {

    public BathDecorator(Pet pet) {
        super(pet);
    }

    private int playsRemains = 5;

    @Override
    public String displayName(Pet pet) {
        return "🛁 " + pet.getName();
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
        if (pet.getCurrentState() instanceof StateHappy) {
            if (playsRemains <= 0) {
                System.out.println(pet.getName() + " se sujou brincando e o efeito do banho acabou!");
                pet.setBath(null);
            }
        }
    }

    @Override
    public void wakeUp(Pet pet) {
        pet.setHappiness((clamp(pet.getHappiness() + 10)));
        pet.setHealth((clamp(pet.getHealth() + 5)));
        System.out.println(pet.getName() + " ficou renovado após o banho 🫧. ( 5+ saúde; 10+ felicidade)");
    }

}
