package com.atexo.exercice.card.game.service;

import com.atexo.exercice.card.game.model.domain.Card;
import com.atexo.exercice.card.game.model.domain.Number;
import com.atexo.exercice.card.game.model.domain.Sign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


public class HandSerivceTest {

    @Autowired
    HandService handService;

    List<Card> givenHand, expectedHand;

    @BeforeEach
    public void setUp() {
        givenHand = Arrays.asList(
                new Card(Number.As, Sign.Carreaux),
                new Card(Number.Deux, Sign.Trefle),
                new Card(Number.Trois, Sign.Carreaux),
                new Card(Number.Valet, Sign.Coeur),
                new Card(Number.cinq, Sign.Pique),
                new Card(Number.Roi, Sign.Pique),
                new Card(Number.huit, Sign.Trefle),
                new Card(Number.As, Sign.Coeur),
                new Card(Number.Dame, Sign.Trefle),
                new Card(Number.dix, Sign.Carreaux)
        );
        expectedHand = Arrays.asList(
            new Card(Number.As, Sign.Carreaux),
            new Card(Number.Trois, Sign.Carreaux),
            new Card(Number.dix, Sign.Carreaux),
            new Card(Number.As, Sign.Coeur),
            new Card(Number.Valet, Sign.Coeur),
            new Card(Number.cinq, Sign.Pique),
            new Card(Number.Roi, Sign.Pique),
            new Card(Number.Deux, Sign.Trefle),
            new Card(Number.huit, Sign.Trefle),
            new Card(Number.Dame, Sign.Trefle)
        );
    }

    @Test
    public void should_return_random_list_of_ten_card() {

        List<Card> hand = handService.getRandomHand(10);

        Assertions.assertNotNull(hand);
        Assertions.assertEquals(hand.size(), 10);

    }

    @Test
    public void should_sort_given_hand(){

        List<Card> sortedHand = handService.sort(givenHand);

        Assertions.assertIterableEquals(sortedHand, expectedHand);
    }
}
