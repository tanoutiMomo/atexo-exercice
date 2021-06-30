package com.atexo.exercice.card.game.service;

import com.atexo.exercice.card.game.model.domain.Card;
import com.atexo.exercice.card.game.model.domain.HandFacotry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HandService {


    public List<Card> getRandomHand(Integer numberOfCard) {
        return HandFacotry.generateHandOfCard(numberOfCard);
    }

    public List<Card> sort(List<Card> handToSort) {

        return handToSort.stream().sorted().collect(Collectors.toList());
    }
}
