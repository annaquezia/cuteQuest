package model.command;

import model.Pet;
import ui.UiScene;

import java.util.Objects;

public class SleepCommand implements Command {
    private Pet pet;

    public SleepCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.sleep();
    }

    @Override
    public int timeCostHours() {
        return 0;
    }

    @Override
    public UiScene sceneHint() {
        return UiScene.SLEEP;
    }

    @Override
    public String description() {
        return "Colocando " + pet.getName() + " para dormir";
    }

}
