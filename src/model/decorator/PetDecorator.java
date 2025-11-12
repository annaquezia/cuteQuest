package model.decorator;

import model.Pet;

public abstract class PetDecorator implements PetComponent{

    PetComponent wrapee;

    public PetDecorator(PetComponent wrapee) {
        this.wrapee = wrapee;
    }

    public String displayName(Pet pet) {
        return pet.getName();
    }

    public void feed(Pet pet) {
    }
    public void play(Pet pet) {
    }
    public void heal(Pet pet) {
    }
    public void sleep(Pet pet) {
    }
    public void wakeUp(Pet pet) {
    }

    public void tick(Pet pet, int hours) {
    }

    public String getName() {
        return wrapee.getName();
    }

    public void setName(String name) {
    }

    public int getHealth() {
        return wrapee.getHealth();
    }

    public void setHealth(int health) {
    }

    public int getHappiness(){
        return wrapee.getHappiness();
    }

    public void setHappiness(int happiness){
    }


    protected int clamp(int v) { return Math.max(0, Math.min(100, v)); }

}
