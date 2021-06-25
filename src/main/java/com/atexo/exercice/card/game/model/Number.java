package com.atexo.exercice.card.game.model;

import java.util.stream.Stream;

public enum Number {

    As(1, "As"),
    Deux(2, "two"),
    Trois(3, "three"),
    quatre(4, "quatre"),
    cinq(5, "cinq"),
    six(6, "six"),
    sept(7, "sept"),
    huit(8, "huit"),
    neuf(9, "neuf"),
    dix(10, "dix"),
    Valet(11, "valet"),
    Dame(12, "dame"),
    Roi(13, "roi");

    public final String label;
    public final Integer value;

    Number(Integer value, String label) {
        this.label = label;
        this.value = value;
    };

    public static Number of(int value) {
        return Stream.of(values()).filter(number -> number.value == value).findFirst().get();
    }
}
