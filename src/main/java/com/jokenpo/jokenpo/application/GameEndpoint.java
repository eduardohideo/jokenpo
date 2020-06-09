package com.jokenpo.jokenpo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameEndpoint {

    @Autowired
    GameFacade gameFacade;

    public GameEndpoint(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> play() {
        return ResponseEntity.ok(gameFacade.play());
    }
}
