package model;

public enum PetType {
    DOG(1, "Cachorro"),
    CAT(2, "Gato"),
    BUNNY(3, "Coelho"),
    HAMSTER(4, "HamsterCreator");

    private int id;
    private String displayName;

     PetType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PetType fromId(int id) {
        for (PetType type : PetType.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Código inválido " + id);
    }





}
