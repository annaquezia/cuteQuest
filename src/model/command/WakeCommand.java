package model.command;

import model.Pet;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
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
        if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
            return UiScene.BATH_BOW;
        } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
            return UiScene.BATH_SCARF;
        } else if (pet.getBath() != null) {
            return UiScene.BATH;
        } else if (pet.getAcessory() != null) {
            if (pet.getAcessory() instanceof BowDecorator) {
                return UiScene.BOW;
            } else {
                return UiScene.SCARF;
            }
        } else {
            return UiScene.WAKE;
        }
    }

    @Override
    public String description() {
        return "Acordar " + pet.getName();
    }
}
