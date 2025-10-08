package model.command;

import model.Pet;
import model.SimulationClock;
import model.state.StateHungry;
import model.state.StateSick;
import model.state.StateTired;
import ui.ConsoleArtRender;
import ui.UiScene;

public class CommandRunner {
    private SimulationClock clock;
    private ConsoleArtRender commandRunner;

    public CommandRunner(SimulationClock clock, ConsoleArtRender runner) {
        this.clock = clock;
        this.commandRunner = runner;
    }

    public void runCommand(Command cmd, Pet pet) {
        cmd.execute();
        int timeCost = cmd.timeCostHours();
        if (timeCost > 0) {
            clock.advance(timeCost);
            pet.tick(timeCost);
        }

        System.out.println("⏱ " + cmd.description() + " | +" + timeCost + "h | now=" + clock.now() + "h");

    }

    private UiScene decideScene(Command cmd, Pet pet) {
        if (pet.getCurrentState() instanceof StateSick) {
            return UiScene.SICK;
        } else if (pet.getCurrentState() instanceof StateTired) {
            return UiScene.TIRED;
        } else if (pet.getCurrentState() instanceof StateHungry) {
            return UiScene.HUNGRY;
        }

        return cmd.sceneHint();
    }
}


