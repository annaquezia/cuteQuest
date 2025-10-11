package model.command;

import model.Pet;
import model.decorator.ScarfDecorator;
import ui.UiScene;

public class ApplyScarfCommand implements Command {
    private Pet pet;

    public ApplyScarfCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.setAcessory(new ScarfDecorator());
    }

    public int timeCostHours() {
        return 0;
    }

    public UiScene sceneHint() {
        return UiScene.SCARF;
    }

    public String description() {
        return "Colocar cachecol em " + pet.getName();
    }
}
