package model.command;

import model.Pet;
import ui.UiScene;

import java.util.Objects;

public class FeedCommand implements Command {
    private Pet pet;

    public FeedCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.feed();
    }

    @Override
    public int timeCostHours() {
        return 1;
    }

    @Override
    public UiScene sceneHint() {
        return UiScene.FEED;
    }

    @Override
    public String description() {
        return "Alimentar" + pet.getName();
    }
}
