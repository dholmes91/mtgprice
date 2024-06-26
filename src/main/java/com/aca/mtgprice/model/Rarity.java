package com.aca.mtgprice.model;

public enum Rarity {
    Common, Uncommon, Rare, Mythic;

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
