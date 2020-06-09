package com.jokenpo.jokenpo.application;

import com.jokenpo.jokenpo.application.exception.InvalidPlayerNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerEndpoint {

    @Autowired
    PlayerFacade playerFacade;

    public PlayerEndpoint(PlayerFacade playerFacade) {
        this.playerFacade = playerFacade;
    }

    @GetMapping(path = "/player/{playerName}")
    public ResponseEntity<PlayerDTO> get(@PathVariable String playerName) {
        validateName(playerName);
        PlayerDTO playerDTO = playerFacade.getPlayer(playerName);
        return ResponseEntity.ok(playerDTO);
    }

    @GetMapping(path = "/players")
    public ResponseEntity<List<PlayerDTO>> getAll() {
        return ResponseEntity.ok(playerFacade.getAllPlayers());
    }

    @PutMapping(path = "/playerMove")
    public ResponseEntity<PlayerDTO> post(@RequestBody PlayerDTO playerDTO) {
        validatePlayerDTO(playerDTO);
        return ResponseEntity.ok(playerFacade.insertJokenMove(playerDTO));
    }

    @PutMapping(path = "/player/{playerName}")
    public ResponseEntity post(@PathVariable String playerName) {
        validateName(playerName);
        return ResponseEntity.ok(playerFacade.insertPlayer(playerName));
    }


    @DeleteMapping(path = "/player/{playerName}")
    public ResponseEntity delete(@PathVariable String playerName) {
        validateName(playerName);
        playerFacade.deletePlayer(playerName);
        return ResponseEntity.ok().build();
    }

    private void validateName(String playerName) {
        if (playerName.isEmpty()) {
            throw new InvalidPlayerNameException("nome de jogador invalido");
        }
    }

    private void validatePlayerDTO(PlayerDTO playerDTO) {
        if (playerDTO.getName().isEmpty()) {
            throw new InvalidPlayerNameException("nome de jogador invalido");
        }
    }
}
