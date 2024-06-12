package com.aca.mtgprice.model;

public enum CardSet {
    MID, VOW, NEO, SNC, DMU, BRO, ONE, MOM, MAT, WOE, LCI, MKM, OTJ;

    public static CardSet convertStringToGenre(String value) {
        CardSet mySet = null;

        for (CardSet set : CardSet.values()) {
            if (set.toString().equalsIgnoreCase(value)) {
                mySet = set;
                break;
            }
        }
        return mySet;
    }

}
