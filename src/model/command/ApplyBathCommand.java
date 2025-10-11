package model.command;

import model.Pet;
import model.decorator.BathDecorator;
import ui.UiScene;

public class ApplyBathCommand implements Command {
    private Pet pet;

    public ApplyBathCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.setBath(new BathDecorator());
    }

    public int timeCostHours() {
        return 0;
    }

    public UiScene sceneHint() {
        return UiScene.BATH;
    }

    public String description() {
        return "Dar banho em " + pet.getName();
    }
}
