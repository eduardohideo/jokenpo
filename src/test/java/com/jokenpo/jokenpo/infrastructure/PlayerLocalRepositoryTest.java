package com.jokenpo.jokenpo.infrastructure;

import com.jokenpo.jokenpo.domain.PlayerRepository;
import com.jokenpo.jokenpo.domain.repository.PlayerLocalRepository;
import com.jokenpo.jokenpo.domain.Player;
import com.jokenpo.jokenpo.domain.JokenpoMove;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlayerLocalRepositoryTest {

    @Test
    public void shouldReturnEmptyList() {
        PlayerRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        assertEquals(Collections.EMPTY_LIST, localRepository.getAll());
    }

    @Test
    public void shouldAddOnePeople() {
        PlayerRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player("jogador 1", JokenpoMove.PAPER);
        localRepository.save(player1);
        assertEquals(player1, localRepository.getAll().get(0));
    }

    @Test
    public void shouldRemoveOnePeople() {
        PlayerRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player("jogador 1", JokenpoMove.PAPER);
        localRepository.save(player1);
        localRepository.delete(player1.getName());
        assertEquals(Collections.EMPTY_LIST, localRepository.getAll());
    }

    @Test
    public void shouldReturnNullWhenRemoveOnePeopleWithEmptyList() {
        PlayerRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player("jogador 1", JokenpoMove.PAPER);
        assertThrows(NoSuchElementException.class, () -> localRepository.delete(player1.getName()));

    }

    @Test
    public void shouldReturnExceptionWhenUpdateAPeopleInvalid() {
        PlayerRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player("jogador 1", JokenpoMove.PAPER);
        assertThrows(NoSuchElementException.class, () -> localRepository.update(player1));
    }

    @Test
    public void shouldUpdateOnePeople() {
        PlayerRepository localRepository = new PlayerLocalRepository(new PlayerStorage());
        Player player1 = new Player("jogador 1", JokenpoMove.PAPER);
        localRepository.save(player1);
        Player player1Updated = new Player("jogador 1", JokenpoMove.SCISSOR);

        localRepository.update(player1Updated);
        assertEquals(player1, localRepository.getAll().get(0));
    }
}
