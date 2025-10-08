package model;

public class SimulationClock {
    private int hours = 0;

    public int now() {
        return hours;
    }

    public void advance(int delta) {
        if (delta > 0) {
            hours += delta;
        }
    }


}
