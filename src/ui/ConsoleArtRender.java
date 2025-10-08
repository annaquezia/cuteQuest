package ui;

import model.Pet;
import model.PetType;
import ui.art.atlas.*;


public class ConsoleArtRender {

    public void ConsoleArtRender(UiScene uiScene, Pet pet) {
        String[] art = pickArt(uiScene, pet.getType());
        for (String line : art) {
            System.out.println(line);
        }
        System.out.println();
    }

    private String[] pickArt(UiScene uiScene, PetType type) {
        return switch (type) {
            case BUNNY -> switch (uiScene) {
                case IDLE -> BunnyArt.IDLE;
                case PLAY -> BunnyArt.PLAY;
                case FEED -> BunnyArt.FEED;
                case SLEEP -> BunnyArt.SLEEP;
                case WAKE -> BunnyArt.IDLE;
                case SICK -> BunnyArt.SICK;
                case HUNGRY ->  BunnyArt.HUNGRY;
                case TIRED -> BunnyArt.TIRED;
                case HEAL ->  BunnyArt.HEAL;
            };
            case CAT -> switch (uiScene) {
                case IDLE -> CatArt.IDLE;
                case FEED -> CatArt.FEED;
                case PLAY -> CatArt.PLAY;
                case SLEEP -> CatArt.SLEEP;
                case WAKE -> CatArt.IDLE;
                case SICK -> CatArt.SICK;
                case HUNGRY -> CatArt.HUNGRY;
                case TIRED -> CatArt.TIRED;
                case HEAL ->  CatArt.HEAL;
            };
            case DOG -> switch (uiScene) {
                case IDLE -> DogArt.IDLE;
                case FEED -> DogArt.FEED;
                case PLAY -> DogArt.PLAY;
                case SLEEP -> DogArt.SLEEP;
                case WAKE -> DogArt.IDLE;
                case SICK -> DogArt.SICK;
                case HUNGRY -> DogArt.HUNGRY;
                case TIRED -> DogArt.TIRED;
                case HEAL ->  DogArt.HEAL;
            };

            case HAMSTER -> switch (uiScene) {
                case IDLE -> HamsterArt.IDLE;
                case FEED -> HamsterArt.FEED;
                case PLAY -> HamsterArt.PLAY;
                case SLEEP -> HamsterArt.SLEEP;
                case WAKE -> HamsterArt.IDLE;
                case SICK -> HamsterArt.SICK;
                case HUNGRY -> HamsterArt.HUNGRY;
                case TIRED -> HamsterArt.TIRED;
                case HEAL -> HamsterArt.HEAL;
            };
        };
    }
}
