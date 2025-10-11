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
        pet.setAcessory(new BowDecorator());
    }

    public int timeCostHours() {
        return 0;
    }

    public UiScene sceneHint() {
        return UiScene.BOW;
    }

    public String description() {
        return "Colocar laço em " + pet.getName();
    }
}
