package model.command;

import model.Pet;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
import ui.UiScene;

import java.util.Objects;

public class HealCommand implements Command {
    private Pet pet;

    public HealCommand(Pet pet) {
        this.pet = Objects.requireNonNull(pet);
    }

    @Override
    public void execute() {
        pet.heal(pet);
    }

    @Override
    public int timeCostHours() {
        return 1;
    }

    @Override
    public UiScene sceneHint() {
        if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
            return UiScene.HEAL_BATH_BOW;
        } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
            return UiScene.HEAL_BATH_SCARF;
        } else if (pet.getBath() != null) {
            return UiScene.HEAL_BATH;
        } else if (pet.getAcessory() != null) {
            if (pet.getAcessory() instanceof BowDecorator) {
                return UiScene.HEAL_BOW;
            } else {
                return UiScene.HEAL_SCARF;
            }
        } else {
            return UiScene.HEAL;
        }
    }

    @Override
    public String description() {
        return "Curar " + pet.getName();
    }
}
