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
        wrapee.feed(pet);
    }
    public void play(Pet pet) {
        wrapee.play(pet);
    }
    public void heal(Pet pet) {
        wrapee.heal(pet);
    }
    public void sleep(Pet pet) {
        wrapee.sleep(pet);
    }
    public void wakeUp(Pet pet) {
        wrapee.wakeUp(pet);
    }

    public void tick(Pet pet, int hours) {
        wrapee.tick(pet, hours);
    }

    public String getName() {
        return wrapee.getName();
    }

    public void setName(String name) {
        wrapee.setName(name);
    }

    public int getHealth() {
        return wrapee.getHealth();
    }

    public void setHealth(int health) {
        wrapee.setHealth(health);
    }

    public int getHappiness(){
        return wrapee.getHappiness();
    }

    public void setHappiness(int happiness){
        wrapee.setHappiness(happiness);
    }


    protected int clamp(int v) { return Math.max(0, Math.min(100, v)); }

}
