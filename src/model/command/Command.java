package model.command;

import ui.UiScene;

public interface Command {
    void execute();
    int timeCostHours();
    UiScene sceneHint();
    String description();
}
