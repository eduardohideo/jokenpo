package com.jokenpo.jokenpo.domain;

import static java.util.Optional.ofNullable;

public class Player {
    private String name;
    private JokenpoMove jokenMove;


    public Player(String name, JokenpoMove jokenMove) {
        this.name = name;
        this.jokenMove = jokenMove;
    }

    public String getName() {
        return name;
    }

    public JokenpoMove getJokenMove() {
        return jokenMove;
    }

    public static final class Builder {
        private String name;
        private JokenpoMove jokenMove;

        public Builder() {
        }

        public static Builder aPlayerEntity() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withJokenMove(JokenpoMove jokenMove) {
            this.jokenMove = jokenMove;
            return this;
        }

        public Player build() {
            return new Player(name, ofNullable(jokenMove).orElse(JokenpoMove.NULL));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "name='" + name + '\'' +
                ", jokenMove=" + jokenMove +
                '}';
    }
}
