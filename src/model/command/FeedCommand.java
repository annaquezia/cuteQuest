package model.command;

import model.Pet;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
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
        if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
            return UiScene.FEED_BATH_BOW;
        } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
            return UiScene.FEED_BATH_SCARF;
        } else if (pet.getBath() != null) {
            return UiScene.FEED_BATH;
        } else if (pet.getAcessory() != null) {
            if (pet.getAcessory() instanceof BowDecorator) {
                return UiScene.FEED_BOW;
            } else {
                return UiScene.FEED_SCARF;
            }
        } else {
            return UiScene.FEED;
        }
    }

    @Override
    public String description() {
        return "Alimentar" + pet.getName();
    }
}
