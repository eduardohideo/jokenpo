package com.jokenpo.jokenpo.domain;

import com.jokenpo.jokenpo.domain.repository.PlayerLocalRepository;
import com.jokenpo.jokenpo.infrastructure.PlayerStorage;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEndpointTest {

    @Test
    public void shouldReturnNoWinnerWithoutPlayers() {
        Game game = new Game(new PlayerLocalRepository(new PlayerStorage()));
        List<Player> winners = game.getWinners();
        assertEquals(Collections.emptyList(), winners);
    }

    @Test
    public void shouldReturnEmptyListsWithAPlayerThatNotPlayed() {
        PlayerLocalRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player.Builder().withJokenMove(JokenpoMove.NULL).withName("jogador 1").build();
        localRepository.save(player1);
        Game game = new Game(localRepository);
        List<Player> winners = game.getWinners();
        assertEquals(Collections.emptyList(), winners);
    }

    @Test
    public void shouldReturnEmptyListsWithOnlyOneJokenpoMove() {
        PlayerLocalRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player.Builder().withJokenMove(JokenpoMove.PAPER).withName("jogador 1").build();
        localRepository.save(player1);
        Game game = new Game(localRepository);
        List<Player> winners = game.getWinners();
        assertEquals(Collections.emptyList(), winners);
    }

    @Test
    public void shouldReturnAWinnerWithTwoJokenpoMove() {
        PlayerLocalRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player.Builder().withJokenMove(JokenpoMove.PAPER).withName("jogador 1").build();
        Player player2 = new Player.Builder().withJokenMove(JokenpoMove.SCISSOR).withName("jogador 2").build();
        localRepository.save(player1);
        localRepository.save(player2);
        Game game = new Game(localRepository);
        List<Player> winners = game.getWinners();
        assertEquals(player2, winners.get(0));
    }

    @Test
    public void shouldReturnEmptyListWithThreeJokenpoMove() {
        PlayerLocalRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player.Builder().withJokenMove(JokenpoMove.PAPER).withName("jogador 1").build();
        Player player2 = new Player.Builder().withJokenMove(JokenpoMove.SCISSOR).withName("jogador 2").build();
        Player player3 = new Player.Builder().withJokenMove(JokenpoMove.ROCK).withName("jogador 3").build();
        localRepository.save(player1);
        localRepository.save(player2);
        localRepository.save(player3);
        Game game = new Game(localRepository);
        List<Player> winners = game.getWinners();
        assertEquals(Collections.emptyList(), winners);
    }
}
