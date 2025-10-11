package model.command;

import model.Pet;
import ui.UiScene;

public class ClearDecoratorCommand implements Command {
    private Pet pet;

    public ClearDecoratorCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.setAcessory(null);
        System.out.println("Enfeites removidos de " + pet.getName() + ". ✓");
    }

    public int timeCostHours() {
        return 0;
    }

    public UiScene sceneHint() {
        return UiScene.IDLE;
    }

    public String description() {
        return "Remover enfeites de " + pet.getName();
    }
}
