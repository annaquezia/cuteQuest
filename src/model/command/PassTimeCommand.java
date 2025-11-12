package model.command;

import model.Pet;
import ui.UiScene;

import java.util.Objects;

public class PassTimeCommand implements Command {
    private Pet pet;
    private int hours;

    public PassTimeCommand(Pet pet, int hours) {
        this.pet = Objects.requireNonNull(pet);
        this.hours = Math.max(0, hours);
    }

    @Override
    public void execute() {}

    @Override
    public int timeCostHours(){
        return hours;
    }

    @Override
    public UiScene sceneHint() {
        return null;
    }

    @Override
    public String description() {
        return "Passar " + hours + "h para " + pet.getName();
    }
}
