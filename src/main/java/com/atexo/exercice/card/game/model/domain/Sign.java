package com.atexo.exercice.card.game.model.domain;

import java.util.stream.Stream;

public enum Sign {

    Carreaux(1, "carreaux"),
    Coeur(2, "coeur"),
    Pique(3, "pique"),
    Trefle(4, "trefle");

    public final String label;
    public final Integer value;

    Sign(Integer value, String label) {
        this.label = label;
        this.value = value;
    };

    public static Sign of(int value) {
        return Stream.of(values()).filter(sign -> sign.value.equals(value)).findFirst().get();
    }
}
