package com.atexo.exercice.card.game.controller;

import com.atexo.exercice.card.game.model.Card;
import com.atexo.exercice.card.game.model.HandFacotry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atexo/v1")
public class HandController {

    @GetMapping("/hands")
    public ResponseEntity<List<Card>> getHand() {
        HandFacotry.generateHandOfCard().forEach(System.out::println);
        return new ResponseEntity(HandFacotry.generateHandOfCard(), HttpStatus.OK);
    }
}
