package model.command;

import model.Pet;
import model.SimulationClock;
import model.decorator.BowDecorator;
import model.decorator.ScarfDecorator;
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

        UiScene scene = decideScene(cmd, pet);
        if (scene != null) {
            commandRunner.ConsoleArtRender(scene, pet);
        }


        System.out.println("⏱ Custou: " + timeCost + "h | Agora: " + clock.now() + "h");

    }

    private UiScene decideScene(Command cmd, Pet pet) {
        if (pet.getCurrentState() instanceof StateSick) {
            if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
                return UiScene.SICK_BATH_BOW;
            } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
                return UiScene.SICK_BATH_SCARF;
            } else if (pet.getBath() != null) {
                return UiScene.SICK_BATH;
            } else if (pet.getAcessory() != null) {
                if (pet.getAcessory() instanceof BowDecorator) {
                    return UiScene.SICK_BOW;
                } else {
                    return UiScene.SICK_SCARF;
                }
            } else {
                return UiScene.SICK;
            }
        } else if (pet.getCurrentState() instanceof StateTired) {
            if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
                return UiScene.TIRED_BATH_BOW;
            } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
                return UiScene.TIRED_BATH_SCARF;
            } else if (pet.getBath() != null) {
                return UiScene.TIRED_BATH;
            } else if (pet.getAcessory() != null) {
                if (pet.getAcessory() instanceof BowDecorator) {
                    return UiScene.TIRED_BOW;
                } else {
                    return UiScene.TIRED_SCARF;
                }
            } else {
                return UiScene.TIRED;
            }
        } else if (pet.getCurrentState() instanceof StateHungry) {
            if (pet.getBath() != null && pet.getAcessory() instanceof BowDecorator) {
                return UiScene.HUNGRY_BATH_BOW;
            } else if (pet.getBath() != null && pet.getAcessory() instanceof ScarfDecorator) {
                return UiScene.HUNGRY_BATH_SCARF;
            } else if (pet.getBath() != null) {
                return UiScene.HUNGRY_BATH;
            } else if (pet.getAcessory() != null) {
                if (pet.getAcessory() instanceof BowDecorator) {
                    return UiScene.HUNGRY_BOW;
                } else {
                    return UiScene.HUNGRY_SCARF;
                }
            } else {
                return UiScene.HUNGRY;
            }
        }
        UiScene scene = cmd.sceneHint();
        if (scene == null) {
            return UiScene.IDLE;
        }
        return cmd.sceneHint();
    }
}


