package model.command;

import model.Pet;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
import ui.UiScene;

import java.util.Objects;

public class SleepCommand implements Command {
    private Pet pet;

    public SleepCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.sleep(pet);
    }

    @Override
    public int timeCostHours() {
        return 0;
    }

    @Override
    public UiScene sceneHint() {
        if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
            return UiScene.SLEEP_BATH_BOW;
        } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
            return UiScene.SLEEP_BATH_SCARF;
        } else if (pet.getBath() != null) {
            return UiScene.SLEEP_BATH;
        } else if (pet.getAcessory() != null) {
            if (pet.getAcessory() instanceof BowDecorator) {
                return UiScene.SLEEP_BOW;
            } else {
                return UiScene.SLEEP_SCARF;
            }
        } else {
            return UiScene.SLEEP;
        }
    }

    @Override
    public String description() {
        return "Colocando " + pet.getName() + " para dormir";
    }

}
