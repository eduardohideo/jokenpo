package com.jokenpo.jokenpo.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JokenpoMoveTest {

    @Test
    public void shouldReturnNullWithEmptySet() {
        assertEquals(JokenpoMove.NULL, JokenpoMove.getWinner(Collections.EMPTY_SET));
    }

    @Test
    public void shouldReturnErrorWithNullObjectInTheSet() {
        Set<JokenpoMove> moveSet = new HashSet<>();
        moveSet.add(JokenpoMove.NULL);
        assertThrows(IllegalArgumentException.class, () -> JokenpoMove.getWinner(moveSet));
    }

    @Test
    public void shouldReturnTheMoveWithOnlyOneMoveInTheSet() {
        Set<JokenpoMove> moveSet = new HashSet<>();
        moveSet.add(JokenpoMove.PAPER);
        assertEquals(JokenpoMove.NULL, JokenpoMove.getWinner(moveSet));
    }

    @Test
    public void shouldReturnTheWinnerWithTwoMoves() {
        Set<JokenpoMove> moveSet1 = new HashSet<>();
        moveSet1.add(JokenpoMove.PAPER);
        moveSet1.add(JokenpoMove.SCISSOR);
        Set<JokenpoMove> moveSet2 = new HashSet<>();
        moveSet2.add(JokenpoMove.PAPER);
        moveSet2.add(JokenpoMove.ROCK);
        Set<JokenpoMove> moveSet3 = new HashSet<>();
        moveSet3.add(JokenpoMove.SCISSOR);
        moveSet3.add(JokenpoMove.ROCK);
        assertEquals(JokenpoMove.SCISSOR, JokenpoMove.getWinner(moveSet1));
        assertEquals(JokenpoMove.PAPER, JokenpoMove.getWinner(moveSet2));
        assertEquals(JokenpoMove.ROCK, JokenpoMove.getWinner(moveSet3));
    }
}
