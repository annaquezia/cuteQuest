package ui;

import model.Pet;
import model.SimulationClock;
import model.command.CommandRunner;
import model.factory.PetFactory;
import repo.KennelRepo;
import repo.PetRepo;

import java.util.*;

import static model.PetType.*;
import static model.factory.PetFactory.createPet;

public class GameMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final SimulationClock clock = new SimulationClock();
    private final ConsoleArtRender renderer = new ConsoleArtRender();
    private final CommandRunner runner = new CommandRunner(clock, renderer);
    private final KennelRepo kennelRepo = new KennelRepo();
    private final PetFactory petFactory  = new PetFactory();

    public void start() {
        System.out.println("=========== PET SHOP LITTLE CATS ===========\n");

        if (kennelRepo.getAllKennel().isEmpty()) {
            OptionFirstGame();
        }

    }


    public void OptionFirstGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Pet Shop Little Cats, aqui você irá cuidar de vários animais\n" +
                "extremamente fofinhos");
        System.out.println("Como é sua primeira vez aqui, o primeiro passo é criar o seu animalzinho!");
        System.out.println("Você pode escolher entre cachorro, gato, coelho e hamster. Qual a sua escolha? \n");
        System.out.println("1. Gato\n" +
                            "2.Cachorro\n" +
                            "3.Coelho\n" +
                            "4.Hamster.\n" +
                            "Sua escolha: ");

        int type = scanner.nextInt();
        if (type < 1 || type > 4) {
            System.out.println("Digite uma opção válida: ");
            int validType = scanner.nextInt();
            type = validType;
        }
        System.out.println("Agora está na hora de você escolher o nome do seu bichinho");
        System.out.println("Digite o nome: ");
        String name  = scanner.nextLine();
        switch (type) {
            case 1:
                Pet cat = PetFactory.createPet(name, CAT);
                break;
            case 2:
                Pet dog = PetFactory.createPet(name, DOG);
                break;
            case 3:
                Pet bunny = PetFactory.createPet(name, BUNNY);
                break;
            case 4:
                Pet hamster = PetFactory.createPet(name, HAMSTER);
                break;
        }
    }
}

