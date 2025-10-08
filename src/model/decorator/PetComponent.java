package model.decorator;

public interface PetComponent {

    void feed();
    void play();
    void sleep();
    void wakeUp();
    void heal();
    void tick(int hours);

    String getName();
    void setName(String name);

    int getHealth();
    void setHealth(int health);

    int getHappiness();
    void setHappiness(int happiness);

    default String displayName() {
        return getName();
    }
}
