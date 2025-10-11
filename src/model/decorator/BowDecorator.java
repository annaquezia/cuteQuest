package model.decorator;

import model.Pet;

public class BowDecorator extends PetDecorator {
    private int playsRemains = 3;

    @Override
    public String displayName(Pet pet){
        return "🎀 " + pet.getName();
    }

    @Override
    public void onPlay(Pet pet) {
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
