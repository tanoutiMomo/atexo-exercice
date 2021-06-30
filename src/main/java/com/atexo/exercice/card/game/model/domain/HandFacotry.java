package com.atexo.exercice.card.game.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class HandFacotry {
    //since we have 13 Number the bounders go from 0 to 12
    final static Integer boundOfRandomNumber = 12;
    //since we have 4 Sign the bounders go from 0 to 3
    final static Integer boundOfRandomSign = 3;

    public static List<Card> generateHandOfCard(Integer numberOfCard) {
        List<Card> hand = new ArrayList<>();
        Random random = new Random();
        IntStream.iterate(0, i -> i + 1).limit(numberOfCard).forEach( x -> {
            int random_number = random.nextInt(boundOfRandomNumber);
            int random_sign = random.nextInt(boundOfRandomSign);
            hand.add(new Card(Number.of(random_number+1), Sign.of(random_sign+1)));
        });
        return hand;
    }
}
