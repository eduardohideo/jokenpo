package com.jokenpo.jokenpo.application;

import java.util.List;


public interface PlayerFacade {
    PlayerDTO insertPlayer(String name);

    PlayerDTO deletePlayer(String name);

    PlayerDTO insertJokenMove(PlayerDTO playerDTO);

    List<PlayerDTO> getAllPlayers();

    PlayerDTO getPlayer(String name);
}
