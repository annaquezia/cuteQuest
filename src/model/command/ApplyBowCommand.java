package model.command;

import model.Pet;
import model.decorator.BowDecorator;
import ui.UiScene;

public class ApplyBowCommand implements Command {

    public ApplyBowCommand(Pet pet) {
        this.pet = pet;
    }

    private Pet pet;

    public void execute() {
        pet.setAcessory(new BowDecorator(pet));
    }

    public int timeCostHours() {
        return 0;
    }

    public UiScene sceneHint() {
        if (pet.getBath() != null) {
            return UiScene.BATH_BOW;
        } else {
            return UiScene.BOW;
        }
    }

    public String description() {
        return "Colocar laço em " + pet.getName();
    }
}
