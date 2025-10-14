package ui;

import model.Pet;
import model.PetType;
import model.SimulationClock;
import model.command.CommandRunner;
import repo.KennelRepo;
import model.factory.PetCreator;
import model.factory.PetFactoryProvider;
import repo.PetRepo;

import java.util.*;

import static model.PetType.*;

public class GameMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final SimulationClock clock = new SimulationClock();
    private final ConsoleArtRender renderer = new ConsoleArtRender();
    private final CommandRunner runner = new CommandRunner(clock, renderer);
    private final KennelRepo kennelRepo = new KennelRepo();
    private final PetRepo petRepo = new PetRepo();

    public void start() {
        System.out.println("=========== LITTLE CATS PET SHOP ===========\n");
        Pet current;
        if (kennelRepo.getAllKennel().isEmpty()) {
            current = optionFirstGame();
        } else {
            current = optionsOldGame();
        }

        while (true) {
            current = menu(current);
        }

    }

    public Pet optionFirstGame() {
        System.out.println("Bem vindo ao Little Cats Pet Shop, aqui você irá cuidar de vários animais\n" +
                "extremamente fofinhos");
        System.out.println("Como é sua primeira vez aqui, o primeiro passo é criar o seu animalzinho!");
        return createPet();
    }

    public Pet optionsOldGame() {
        System.out.println("Bem-vindo de volta ao Little Cats Pet Shop!! \n" +
                            "Sentimos a sua falta");
        return choosePet();
    }

    public void listPets() {
        var pets = petRepo.getAllPets();
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            String state = pet.getCurrentState().getStateName();
            String kennelName = "-";
            if (pet.getKennelID() != null) {
                var kennel = kennelRepo.getKennel(pet.getKennelID());
                if (kennel != null) {
                    kennelName = kennel.get().getKennelName();
                }
            }
            System.out.println(i + 1 + "." + pet.getName() + " | " + pet.getType() + " | " + state + " | " + kennelName);
        }
    }


    public Pet createPet() {
        System.out.println("Você pode escolher entre cachorro, gato, coelho e hamster. Qual a sua escolha? \n");
        System.out.print("""
                ------ Opções ------
                1. Gato
                2. Cachorro
                3. Coelho
                4. Hamster
                0. Voltar
                ---------------------
                """);
        System.out.println("Digite o número da sua escolha: ");

        int type = scanner.nextInt();
        scanner.nextLine();
        while (type < 1 || type > 4) {
            System.out.println("Digite uma opção válida: ");
            int validType = scanner.nextInt();
            scanner.nextLine();
            type = validType;
        }
        System.out.println("Agora está na hora de você escolher o nome do seu bichinho");
        System.out.println("Digite o nome: ");
        String name = scanner.nextLine();

        PetType petType = switch (type) {
            case 1 -> CAT;
            case 2 -> DOG;
            case 3 -> BUNNY;
            case 4 -> HAMSTER;
            default -> null;
        };

        PetCreator creator = PetFactoryProvider.forType(petType, petRepo, kennelRepo);
        Pet pet = creator.newPet(name);

        if (pet != null) {
            System.out.println("Você criou " + pet.getName() + "!");
            renderer.ConsoleArtRender(UiScene.IDLE, pet);
            System.out.println("\n========= Seus pets =========");
            listPets();
        }
        return pet;
    }

    public Pet choosePet() {
        var pets = petRepo.getAllPets();
        System.out.println("=========== Escolha um pet para cuidar ===========");
        System.out.println("0. Voltar ");
        listPets();
        System.out.println("\nDigite o número do pet: ");
        int petNumber = scanner.nextInt();

        while (petNumber < 0 || petNumber > pets.size()) {
            System.out.println("Digite uma opção válida: ");
            int validNumber = scanner.nextInt();
            scanner.nextLine();
            petNumber = validNumber;
        }

        if (petNumber == 0) {
            return null;
        } else {
            return pets.get(petNumber - 1);
        }
    }

    public void showPetStatus(Pet pet) {
        String name = pet.getName();
        String state = pet.getCurrentState().getStateName();
        String kennelName = "-";
        if (pet.getKennelID() != null) {
            var kennel = kennelRepo.getKennel(pet.getKennelID());
            if (kennel != null) {
                kennelName = kennel.get().getKennelName();
            }
        }
        int health = pet.getHealth();
        int happiness = pet.getHappiness();
        int playCount = pet.getPlayCount();
        int feedCount = pet.getFeedCount();

        System.out.println("Nome: " + name + " | Estado: " + state + " | Saúde: " + health + " | Felicidade: " + happiness + " | Baia: " + kennelName);
        System.out.println("Brincou: " + playCount + "vezes | Comeu: " + feedCount + "vezes");
    }

    public Pet menu(Pet pet) {
        System.out.println("""
        --------- Menu ----------
        1. Alimentar
        2. Brincar
        3. Dormir
        4. Acordar
        5. Cuidar
        6. Adicionar acessórios
        7. Passar horas
        8. Trocar/Criar pet
        9. Status do pet
        0. Sair
        --------------------------
        """);
        int option = scanner.nextInt();
        if (option < 0 || option > 9) {
            System.out.println("Digite um uma opção válida: ");
            int validOption = scanner.nextInt();
            scanner.nextLine();
            option = validOption;
        }

        switch (option) {
            case 1:
                runner.runCommand(new model.command.FeedCommand(pet), pet);
                break;
            case 2:
                runner.runCommand(new model.command.PlayCommand(pet), pet);
                break;
            case 3:
                runner.runCommand(new model.command.SleepCommand(pet), pet);
                break;
            case 4:
                runner.runCommand(new model.command.WakeCommand(pet), pet);
                break;
            case 5:
                careMenu(pet);
                break;
            case 6:
                decorMenu(pet);
                break;
            case 7:
                System.out.println("Digite números inteiros entre 0 e 24");
                System.out.println("Horas:  ");
                int hours  = scanner.nextInt();
                while (hours < 0 || hours > 24) {
                    System.out.println("Digite uma hora entre 0 e 24: ");
                    int validHours = scanner.nextInt();
                    scanner.nextLine();
                    hours = validHours;
                }
                runner.runCommand(new model.command.PassTimeCommand(pet, hours), pet);
                break;
            case 8:
                Pet selected = changePetMenu();
                if (selected != null) {
                    pet = selected;
                    System.out.println("Agora você está cuidando de: " + pet.getName());
                    renderer.ConsoleArtRender(UiScene.IDLE, pet);
                }
                break;
            case 9:
                showPetStatus(pet);
                break;
            case 0:
                System.out.println("Certeza que você deseja sair? (s/n) ");
                String optionExit = scanner.nextLine();
                while (true) {
                    if (optionExit.equalsIgnoreCase("s")) {
                        System.out.println("aaaah que pena! :(");
                        System.out.println("seus bichinhos vão estar aqui te esperando <3");
                        System.out.println("volta logo!!");
                        System.exit(0);
                    } else if (optionExit.equalsIgnoreCase("n")) {
                        System.out.println("Que bom que você ficou!!!");
                        menu(pet);
                        break;
                    } else {
                        System.out.println("Escolha uma opção válida: (s/n) ");
                        String validOptionExit = scanner.nextLine();
                        scanner.nextLine();
                        optionExit = validOptionExit;
                    }
                }
            break;
        }
        return pet;
    }

    public void careMenu(Pet pet) {
        System.out.println("""
        --------- Cuidar ----------
        1. Dar banho 🛁🫧
        2. Curar 💊
        0. Voltar para o menu
        ---------------------------
        """);

        int option = scanner.nextInt();
        if (option < 0 || option > 2) {
            System.out.println("Digite um uma opção válida: ");
            int validOption = scanner.nextInt();
            scanner.nextLine();
            option = validOption;
        }
        switch (option) {
            case 1:
                runner.runCommand(new model.command.ApplyBathCommand(pet), pet);
                System.out.println(pet.getName() + " agora está cheirosin! 🫧");
                break;
            case 2:
                runner.runCommand((new model.command.HealCommand(pet)), pet);
                break;
            case 0:
                break;
        }
    }

    public void decorMenu(Pet pet) {
        System.out.println("""
        --------- Decorações ----------
        1. Laço 🎀
        2. Cachecol 🧣
        3. Tirar enfeites
        0. Voltar para o menu
        -------------------------------
        """);
        int option = scanner.nextInt();
        if (option < 0 || option > 3) {
            System.out.println("Digite um uma opção válida: ");
            int validOption = scanner.nextInt();
            scanner.nextLine();
            option = validOption;
        }
        switch (option) {
            case 1:
                if (pet.getAcessory() != null) {
                    System.out.println(pet.getName() + " já está usando o cachecol, quer trocar pelo laço? (s/n) ");
                    String optionBow =  scanner.nextLine();
                    while (true) {
                        if (optionBow.equalsIgnoreCase("s")) {
                            runner.runCommand(new model.command.ApplyBowCommand(pet), pet);
                            System.out.println(pet.getName() + " agora está de laço 🎀");
                            break;
                        } else if (optionBow.equalsIgnoreCase("n")) {
                            System.out.println(pet.getName() + " ainda está de cachecol!");
                            break;
                        } else {
                            System.out.println("Digite uma opção válida (s/n) ");
                            String validOptionBow = scanner.nextLine();
                            optionBow = validOptionBow;
                        }
                    }
                } else {
                    runner.runCommand(new model.command.ApplyBowCommand(pet), pet);
                    System.out.println(pet.getName() + " agora está de laço 🎀");
                }
                break;
            case 2:
                if (pet.getAcessory() != null) {
                    System.out.println(pet.getName() + " já está usando laço, quer trocar pelo cachecol? (s/n) ");
                    String optionScarf = scanner.nextLine();
                    while (true) {
                        if (optionScarf.equalsIgnoreCase("s")) {
                            runner.runCommand(new model.command.ApplyScarfCommand(pet), pet);
                            System.out.println(pet.getName() + " agora está de cachecol 🧣");
                            break;
                        } else if (optionScarf.equalsIgnoreCase("n")) {
                            System.out.println(pet.getName() + " ainda está de laço!");
                            break;
                        } else {
                            System.out.println("Digite uma opção válida (s/n) ");
                            String validOptionScarf = scanner.nextLine();
                            optionScarf = validOptionScarf;
                        }
                    }
                } else {
                    runner.runCommand(new model.command.ApplyScarfCommand(pet), pet);
                    System.out.println(pet.getName() + " agora está de cachecol 🧣");
                }
                break;
            case 3:
                if (pet.getAcessory() != null) {
                    while (true) {
                        System.out.println("Tem certeza que quer tirar o acessório? (s/n) ");
                        String optionTake = scanner.nextLine();
                        if (optionTake.equalsIgnoreCase("s")) {
                            runner.runCommand(new model.command.ClearDecoratorCommand(pet), pet);
                            System.out.println(pet.getName() + " está sem nenhum acessório");
                            break;
                        } else if (optionTake.equalsIgnoreCase("n")) {
                            System.out.println(pet.getName() + " continua com o acessório");
                            break;
                        } else {
                            System.out.println("Digite uma opção válida (s/n) ");
                            String validOptionTake = scanner.nextLine();
                            optionTake = validOptionTake;
                        }
                    }
                } else if (pet.getAcessory() == null) {
                    System.out.println(pet.getName() + " não está usando nenhum acessório");
                    break;
                }
            case 0:
                break;
        }
    }

    public Pet changePetMenu() {
        System.out.println("""
        --------- Menu ----------
        1. Trocar de pet
        2. Criar pet
        0. Voltar
        -------------------------
        """);
        int option = scanner.nextInt();
        if (option < 0 || option > 2) {
            System.out.println("Digite um uma opção válida: ");
            int validOption = scanner.nextInt();
            scanner.nextLine();
            option = validOption;
        }
        switch (option) {
            case 1:
                Pet chosen = choosePet();
                return chosen;
            case 2:
                Pet created = createPet();
                return created;
            case 0:
                break;
        }
        return null;
    }
}




