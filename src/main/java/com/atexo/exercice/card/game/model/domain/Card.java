package com.atexo.exercice.card.game.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
public class Card implements Comparable<Card> {
    private Number number;
    private Sign sign;

    @Override
    public int compareTo(Card o) {
        return Comparator.comparing((Card p) -> p.sign.value)
                .thenComparing(p -> p.number.value)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", sign=" + sign +
                '}';
    }
}