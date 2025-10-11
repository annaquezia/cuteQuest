package model;

import model.decorator.PetComponent;
import model.decorator.PetDecorator;
import model.state.PetState;

import java.util.UUID;

public abstract class Pet implements PetComponent {
    private UUID id;
    private String name;
    private PetType type;
    private UUID kennelID;
    private int health;
    private int happiness;
    private int playCount;
    private int feedCount;
    private boolean adopted;
    private PetState currentState;
    private PetState lastState;
    private PetDecorator acessory;
    private PetDecorator bath;

    public Pet(String name, PetType type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.health = 100;
        this.happiness = 100;
        this.adopted = false;
    }

    public void feed(){
        currentState.feed(this);
        if (bath != null) {
            bath.onFeed(this);
        }
        if (acessory != null) {
            acessory.onFeed(this);
        }
    }

    public void play(){
        currentState.play(this);
        if (bath != null) {
            bath.onPlay(this);
        }
        if (acessory != null) {
            acessory.onPlay(this);
        }
    }

    public void heal(){
        currentState.heal(this);
        if (bath != null) {
            bath.onHeal(this);
        }
        if (acessory != null) {
            acessory.onHeal(this);
        }
    }

    public void sleep(){
        currentState.sleep(this);
        if (bath != null) {
            bath.onSleep(this);
        }
        if (acessory != null) {
            acessory.onSleep(this);
        }
    }

    public void wakeUp(){
        currentState.wakeUp(this);
        if (bath != null) {
            bath.onWake(this);
        }
        if (acessory != null) {
            acessory.onWake(this);
        }
    }

    public void tick(int hours) {
        currentState.tick(this, hours);
        if (bath != null) {
            bath.onTick(this, hours);
        }
        if (acessory != null) {
            acessory.onTick(this, hours);
        }
    }

    public void incrementPlayCount(){
        playCount++;
    }

    public void resetPlayCount(){
        playCount = 0;
    }

    public void incrementFeedCount(){
        feedCount++;
    }

    public void resetFeedCount(){
        feedCount = 0;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public UUID getKennelID() {
        return kennelID;
    }

    public void setKennelID(UUID kennelID) {
        this.kennelID = kennelID;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = clamp(health, 0, 100);
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = clamp(happiness, 0, 100);
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getFeedCount() {
        return feedCount;
    }

    public void setFeedCount(int feedCount) {
        this.feedCount = feedCount;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public PetState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PetState newState) {
        this.lastState = this.currentState;
        this.currentState = newState;

    }

    public PetState getLastState() {
        return lastState;
    }

    public void setLastState(PetState lastState) {
        this.lastState = lastState;
    }

    public PetDecorator getAcessory() {
        return acessory;
    }

    public void setAcessory(PetDecorator decorator) {
        this.acessory = decorator;
    }

    public PetDecorator getBath() {
        return bath;
    }

    public void setBath(PetDecorator bath) {
        this.bath = bath;
    }

    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
