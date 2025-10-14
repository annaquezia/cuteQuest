package model.command;

import model.Pet;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
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
        if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
            return UiScene.PLAY_BATH_BOW;
        } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
            return UiScene.PLAY_BATH_SCARF;
        } else if (pet.getBath() != null) {
            return UiScene.PLAY_BATH;
        } else if (pet.getAcessory() != null) {
            if (pet.getAcessory() instanceof BowDecorator) {
                return UiScene.PLAY_BOW;
            } else {
                return UiScene.PLAY_SCARF;
            }
        } else {
            return UiScene.PLAY;
        }
    }

    @Override
    public String description() {
        return "Brincar com " + pet.getName();
    }
}
