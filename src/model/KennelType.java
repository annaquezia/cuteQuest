package model;

public enum KennelType {
    DOG(1, "Baia para cachorrinhos ૮ • ﻌ - ა"),
    CAT(2, "Baia para gatinhos /ᐠ - ˕ -マ"),
    BUNNY(3, "Baia para coelhinhos ₍ᐢᐢ₎"),
    HAMSTER(4, "Baia para hamster ʕ̢̣̣̣̣̩̩̩̩·͡˔·ོɁ̡̣̣̣̣̩̩̩̩"),
    SHOWER(5, "Baia para banho ∘˙○˚.•"),
    HOSPITAL(6, "Hospital (๑-﹏-๑)");

    private int id;
    private String displayName;

    KennelType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static KennelType getKennelType(int id) {
        for (KennelType type : KennelType.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Código inválido " + id);
    }
}
