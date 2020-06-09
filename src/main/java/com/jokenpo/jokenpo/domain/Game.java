package com.jokenpo.jokenpo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class Game {

    private PlayerRepository repository;

    @Autowired
    public Game(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getWinners() {
        Map<JokenpoMove, List<Player>> mapMove = groupPlayersByJokenpoMoves();
        return findWinners(mapMove);
    }

    private Map<JokenpoMove, List<Player>> groupPlayersByJokenpoMoves() {
        return repository.getAll().stream().filter(player -> !player.getJokenMove().equals(JokenpoMove.NULL)).collect(Collectors.groupingBy(player -> player.getJokenMove()));
    }

    private List<Player> findWinners(Map<JokenpoMove, List<Player>> mapMove) {
        JokenpoMove winnerMove = JokenpoMove.getWinner(mapMove.keySet());
        return ofNullable(mapMove.get(winnerMove)).orElse(Collections.EMPTY_LIST);
    }
}
