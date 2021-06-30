package com.atexo.exercice.card.game.controller;

import com.atexo.exercice.card.game.model.domain.HandFacotry;
import com.atexo.exercice.card.game.model.request.HandRequest;
import com.atexo.exercice.card.game.service.HandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class HandControllerTest {

    @MockBean
    private HandService handService;

    @Autowired
    HandController handController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        when(handService.getRandomHand(10)).thenReturn(HandFacotry.generateHandOfCard(10));
    }

    @Test
    public void whenPostRequestToHandsAndInValidRequest_thenCorrectResponse() throws Exception {
        String handRequest = "{\"numberOfCard\": \"\", \"orderType\" : \"asc\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/atexo/v1/hands")
                .content(handRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numberOfCard", Is.is("number of card is mandatory")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test void shouldReturnOkWhenTheRequestIsValid() throws Exception {
        HandRequest request = new HandRequest(10,"asc");

        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/atexo/v1/hands")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(request))).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertThat(mvcResult.getResponse().getContentAsString()).isNotBlank();
    }
}
