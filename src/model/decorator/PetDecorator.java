package model.decorator;

import model.Pet;

public abstract class PetDecorator {
    public String displayName(Pet pet) {
        return pet.getName();
    }

    public void onFeed(Pet pet) {}
    public void onPlay(Pet pet) {}
    public void onHeal(Pet pet) {}
    public void onSleep(Pet pet) {}
    public void onWake(Pet pet) {}
    public void onTick(Pet pet, int hours) {}

    protected int clamp01(int v) { return Math.max(0, Math.min(100, v)); }

}
