package com.jokenpo.jokenpo.application;

import com.jokenpo.jokenpo.domain.JokenpoMove;
import com.jokenpo.jokenpo.domain.Player;

public class PlayerDTO {
    private String name;
    private String jokenMove;


    PlayerDTO(String name, String jokenMove) {
        this.name = name;
        this.jokenMove = jokenMove;
    }

    public String getName() {
        return name;
    }

    public String getJokenMove() {
        return jokenMove;
    }

    public static PlayerDTO toDTO(Player player) {
        return new PlayerDTO(player.getName(), player.getJokenMove().getMove());
    }

    public static Player toEntity(PlayerDTO playerDTO) {
        return new Player.Builder().withJokenMove(JokenpoMove.getEnum(playerDTO.getJokenMove())).withName(playerDTO.getName()).build();
    }
}
