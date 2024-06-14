package com.aca.mtgprice.model;

public enum CardType {
    Land, Creature, Artifact, Enchantment, Planeswalker, Battle, Instant, Sorcery;

    public static CardType convertStringToGenre(String value) {
        CardType myType = null;

        for (CardType type : CardType.values()) {
            if (type.toString().equalsIgnoreCase(value)) {
                myType = type;
                break;
            }
        }
        return myType;
    }

}
