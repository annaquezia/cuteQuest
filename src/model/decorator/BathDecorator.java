package model.decorator;

import model.Pet;

public class BathDecorator extends PetDecorator {

    @Override
    public String displayName(Pet pet) {
        return "🛁 " + pet.getName();
    }

    @Override
    public void onWake(Pet pet) {
        pet.setHappiness((clamp01(pet.getHappiness() + 10)));
        pet.setHealth((clamp01(pet.getHealth() + 5)));
        System.out.println(pet.getName() + " ficou renovado após o banho 🫧. ( 5+ saúde; 10+ felicidade)");
    }

}
