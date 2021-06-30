package com.atexo.exercice.card.game.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandRequest {
    @NotBlank(message = "number of card is mandatory")
    @NotNull
    private Integer numberOfCard;
}
