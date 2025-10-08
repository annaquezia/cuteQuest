package model.decorator;

import model.Pet;

public class BowDecorator extends PetDecorator {
    @Override
    public String displayName(Pet pet){
        return "🎀 " + pet.getName();
    }

    @Override
    public void onPlay(Pet pet) {
        pet.setHappiness((clamp01(pet.getHappiness() + 5)));
        System.out.println(pet.getName() + " ficou ainda mais feliz por causa do laço");
    }
}
