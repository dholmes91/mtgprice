package com.aca.mtgprice.model;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    Land, Creature, Artifact, Enchantment, Planeswalker, Battle, Instant, Sorcery, Basic;

    private static final Map<String, Type> typeMappings = new HashMap<>();

    static {
        typeMappings.put("land", Land);
        typeMappings.put("creature", Creature);
        typeMappings.put("artifact", Artifact);
        typeMappings.put("enchantment", Enchantment);
        typeMappings.put("planeswalker", Planeswalker);
        typeMappings.put("battle", Battle);
        typeMappings.put("instant", Instant);
        typeMappings.put("sorcery", Sorcery);
        typeMappings.put("basic", Basic);
        // Add more specific mappings as needed
    }

    public static Type convertStringToType(String value) {

        String lowercaseValue = value.toLowerCase();


        for (Map.Entry<String, Type> entry : typeMappings.entrySet()) {
            if (lowercaseValue.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // Default conversion using enum valueOf
        try {
            return Type.valueOf(lowercaseValue);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
