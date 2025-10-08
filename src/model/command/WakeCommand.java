package model.command;

import model.Pet;
import ui.UiScene;

import java.util.Objects;

public class WakeCommand implements Command {
    private Pet pet;

    public WakeCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.wakeUp();
    }

    @Override
    public int timeCostHours() {
        return 0;
    }

    @Override
    public UiScene sceneHint() {
        return UiScene.WAKE;
    }

    @Override
    public String description() {
        return "Acordar " + pet.getName();
    }
}
