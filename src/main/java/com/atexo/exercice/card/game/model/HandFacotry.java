package com.atexo.exercice.card.game.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class HandFacotry {

    public static List<Card> generateHandOfCard() {
        List<Card> hand = Collections.emptyList();
        Random rand = new Random();
        IntStream.iterate(0, i -> i + 1).limit(10).forEach(x -> {
            // we have 13 number, starting from 0 the bound is 12. each time will return a number to pick
            int number_random = rand.nextInt(12);
            int sign_random = rand.nextInt(3);
            hand.add(new Card(Number.of(number_random), Sign.of(sign_random)));
        });
        return hand;
    }
}
