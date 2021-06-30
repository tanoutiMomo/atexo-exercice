package com.atexo.exercice.card.game.controller;

import com.atexo.exercice.card.game.model.domain.Card;
import com.atexo.exercice.card.game.model.request.HandRequest;
import com.atexo.exercice.card.game.service.HandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/atexo/v1")
@Validated
public class HandController {
    @Autowired
    HandService handService;

    @ExceptionHandler
    @GetMapping("/hands")
    public ResponseEntity<Map<String, List<Card>>> getHand(@Valid HandRequest handRequest) {

        List<Card> cards = handService.getRandomHand(handRequest.getNumberOfCard());

        Map<String, List<Card>> response = new HashMap() {
            {
                put("1_randomHand", cards);
                put("2_sortedHand", handService.sort(cards));
            }
        };
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
