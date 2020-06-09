package com.jokenpo.jokenpo.application.facade;

import com.jokenpo.jokenpo.application.GameFacade;
import com.jokenpo.jokenpo.application.PlayerDTO;
import com.jokenpo.jokenpo.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameFacadeImpl implements GameFacade {

    Game game;

    @Autowired
    public GameFacadeImpl(Game game) {
        this.game = game;
    }

    @Override
    public List<PlayerDTO> play() {
        return game.getWinners().stream().map(player -> PlayerDTO.toDTO(player)).collect(Collectors.toList());
    }
}
