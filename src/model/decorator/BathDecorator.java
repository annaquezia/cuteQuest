package model.decorator;

import model.Pet;

public class BathDecorator extends PetDecorator {
    private int playsRemains = 5;

    @Override
    public String displayName(Pet pet) {
        return "🛁 " + pet.getName();
    }

    @Override
    public void onPlay(Pet pet) {
        playsRemains--;
        if (playsRemains <= 0) {
            System.out.println(pet.getName() + " se sujou brincando e o efeito do banho acabou!");
            pet.setAcessory(null);
        }
    }

    @Override
    public void onWake(Pet pet) {
        pet.setHappiness((clamp01(pet.getHappiness() + 10)));
        pet.setHealth((clamp01(pet.getHealth() + 5)));
        System.out.println(pet.getName() + " ficou renovado após o banho 🫧. ( 5+ saúde; 10+ felicidade)");
    }

}
