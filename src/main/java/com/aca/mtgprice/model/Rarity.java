package com.aca.mtgprice.model;

public enum Rarity {
    C, UC, R, M;

    public static Rarity convertStringToRarity(String value) {
        Rarity myRarity = null;

        for (Rarity rarity : Rarity.values()) {
            if (rarity.toString().equalsIgnoreCase(value)) {
                myRarity = rarity;
                break;
            }
        }
        return myRarity;
    }

}
