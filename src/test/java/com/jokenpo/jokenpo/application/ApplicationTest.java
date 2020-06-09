package com.jokenpo.jokenpo.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void cleanPlayers() throws Exception {
        this.mockMvc.perform(delete("/player/1"));
        this.mockMvc.perform(delete("/player/2"));
    }

    @Test
    public void shouldPlayTheGame() throws Exception {
        this.mockMvc.perform(get("/game")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("[]"));
    }

    @Test
    public void shouldCheckPlayers() throws Exception {
        this.mockMvc.perform(get("/players")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("[]"));
    }

    @Test
    public void shouldInsertkPlayer() throws Exception {
        this.mockMvc.perform(put("/player/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"1\",\"jokenMove\":\"NAO REGISTRADO\"}"));
    }

    @Test
    public void shouldDeleteAValidPlayer() throws Exception {
        this.mockMvc.perform(put("/player/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"1\",\"jokenMove\":\"NAO REGISTRADO\"}"));
        this.mockMvc.perform(delete("/player/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturn400WhenRemoveAPlayerInvalid() throws Exception {
        this.mockMvc.perform(delete("/player/1")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shoulReturn400WhenInsertAjokenMoveWithoutAValidPerson() throws Exception {
        this.mockMvc.perform(put("/playerMove").content("{\"name\":\"1\",\"jokenMove\":\"TESOURA\"}").contentType("application/json")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldInsertAjokenMove() throws Exception {
        this.mockMvc.perform(put("/player/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"1\",\"jokenMove\":\"NAO REGISTRADO\"}"));
        this.mockMvc.perform(put("/playerMove").content("{\"name\":\"1\",\"jokenMove\":\"TESOURA\"}").contentType("application/json")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"1\",\"jokenMove\":\"TESOURA\"}"));
    }

    @Test
    public void shouldPlayTheGameWithTwoPlayers() throws Exception {
        this.mockMvc.perform(put("/player/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"1\",\"jokenMove\":\"NAO REGISTRADO\"}"));
        this.mockMvc.perform(put("/playerMove").content("{\"name\":\"1\",\"jokenMove\":\"PAPEL\"}").contentType("application/json")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"1\",\"jokenMove\":\"PAPEL\"}"));
        this.mockMvc.perform(put("/player/2")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"2\",\"jokenMove\":\"NAO REGISTRADO\"}"));
        this.mockMvc.perform(put("/playerMove").content("{\"name\":\"2\",\"jokenMove\":\"TESOURA\"}").contentType("application/json")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"2\",\"jokenMove\":\"TESOURA\"}"));
        this.mockMvc.perform(get("/game")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("[{\"name\":\"2\",\"jokenMove\":\"TESOURA\"}]"));
    }

}
