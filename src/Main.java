import model.Pet;
import model.PetType;
import model.SimulationClock;
import model.command.CommandRunner;
import model.factory.PetCreator;
import model.factory.PetFactoryProvider;
import repo.KennelRepo;
import repo.PetRepo;
import ui.ConsoleArtRender;
import ui.GameMenu;

public class Main {
    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
        gameMenu.start();
    }
}