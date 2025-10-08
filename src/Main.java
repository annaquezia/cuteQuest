import model.Pet;
import model.PetType;
import model.command.*;
import model.SimulationClock;
import model.factory.PetFactory;
import repo.PetRepo;
import repo.KennelRepo;

public class Main {
    public static void main(String[] args) {
        SimulationClock clock = new SimulationClock();
        CommandRunner runner = new CommandRunner(clock);

        // Cria um pet já inicializado pela Factory (sem NPE garantido)
        Pet luna = PetFactory.createPet("Luna", PetType.BUNNY);

        // sequência de comandos
        runner.runCommand(new PlayCommand(luna), luna);
        runner.runCommand(new PlayCommand(luna), luna);
        runner.runCommand(new PlayCommand(luna), luna);
        runner.runCommand(new PlayCommand(luna), luna);
        runner.runCommand(new PlayCommand(luna), luna);
        runner.runCommand(new PlayCommand(luna), luna); // deve ficar Tired

        runner.runCommand(new SleepCommand(luna), luna);
        runner.runCommand(new PassTimeCommand(luna, 2), luna); // deve dizer que ainda precisa dormir
        runner.runCommand(new WakeCommand(luna), luna);        // “ainda precisa dormir X horas...”
        runner.runCommand(new PassTimeCommand(luna, 2), luna); // completa as 4h de sono
        runner.runCommand(new WakeCommand(luna), luna);        // agora acorda
    }
}