package model;

import jakarta.persistence.*;

@Entity
@Table(name = "simulation_clock")
public class SimulationClock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int hours = 0;

    public SimulationClock() {}

    public int now() {
        return hours;
    }

    public void advance(int delta) {
        if (delta > 0) {
            hours += delta;
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }


}
