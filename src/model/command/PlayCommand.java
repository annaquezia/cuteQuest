package model.command;

import model.Pet;
import ui.UiScene;

import java.util.Objects;

public class PlayCommand implements Command {
    private Pet pet;

    public PlayCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.play();
    }

    @Override
    public int timeCostHours() {
        return 2;
    }

    @Override
    public UiScene sceneHint() {
        return UiScene.PLAY;
    }

    @Override
    public String description() {
        return "Brincar com " + pet.getName();
    }
}
