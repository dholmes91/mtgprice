package com.aca.mtgprice.model;

public enum Type {
    Land, Creature, Artifact, Enchantment, Planeswalker, Battle, Instant, Sorcery, Basic;

    public static Type convertStringToType(String value) {
        Type myType = null;

        for (Type type : Type.values()) {
            if (type.toString().equalsIgnoreCase(value)) {
                myType = type;
                break;
            }
        }
        return myType;
    }

}
