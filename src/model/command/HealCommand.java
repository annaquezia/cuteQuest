package model.command;

import model.Pet;
import ui.UiScene;

import java.util.Objects;

public class HealCommand implements Command {
    private Pet pet;

    public HealCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.heal();
    }

    @Override
    public int timeCostHours() {
        return 1;
    }

    @Override
    public UiScene sceneHint() {
        return UiScene.HEAL;
    }

    @Override
    public String description() {
        return "Curar " + pet.getName();
    }
}
