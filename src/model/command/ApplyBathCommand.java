package model.command;

import model.Pet;
import model.decorator.BathDecorator;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
import ui.UiScene;

public class ApplyBathCommand implements Command {
    private Pet pet;

    public ApplyBathCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.setBath(new BathDecorator(pet));
    }

    public int timeCostHours() {
        return 0;
    }

    public UiScene sceneHint() {
        if (pet.getAcessory() instanceof BowDecorator) {
            return UiScene.BATH_BOW;
        } else if (pet.getAcessory() instanceof ScarfDecorator) {
            return UiScene.BATH_SCARF;
        } else {
            return UiScene.BATH;
        }
    }

    public String description() {
        return "Dar banho em " + pet.getName();
    }
}
