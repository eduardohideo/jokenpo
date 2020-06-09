package com.jokenpo.jokenpo.domain;

import java.util.Set;

public enum JokenpoMove {
    ROCK("PEDRA"), PAPER("PAPEL"), SCISSOR("TESOURA"), NULL("NAO REGISTRADO");

    private final String move;

    private JokenpoMove(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public static JokenpoMove getEnum(String move) {
        for (JokenpoMove jokenpoMove : JokenpoMove.values()) {
            if (jokenpoMove.getMove().equals(move.toUpperCase())) {
                return jokenpoMove;
            }
        }
        return NULL;
    }

    public static JokenpoMove getWinner(Set<JokenpoMove> jokenpoMoves) {
        if (jokenpoMoves.contains(NULL)) {
            throw new IllegalArgumentException("Null object in the set");
        }
        if (jokenpoMoves.size() == 0 || jokenpoMoves.size() == 1) {
            return NULL;
        }
        return getWinnerWithSizeGreaterThan1(jokenpoMoves);
    }

    private static JokenpoMove getWinnerWithSizeGreaterThan1(Set<JokenpoMove> jokenpoMoves) {
        if (!jokenpoMoves.contains(JokenpoMove.PAPER) && jokenpoMoves.contains(JokenpoMove.ROCK) && jokenpoMoves.contains(JokenpoMove.SCISSOR)) {
            return JokenpoMove.ROCK;
        }
        if (jokenpoMoves.contains(JokenpoMove.PAPER) && !jokenpoMoves.contains(JokenpoMove.ROCK) && jokenpoMoves.contains(JokenpoMove.SCISSOR)) {
            return JokenpoMove.SCISSOR;
        }
        if (jokenpoMoves.contains(JokenpoMove.PAPER) && jokenpoMoves.contains(JokenpoMove.ROCK) && !jokenpoMoves.contains(JokenpoMove.SCISSOR)) {
            return JokenpoMove.PAPER;
        }
        return NULL;
    }
}

