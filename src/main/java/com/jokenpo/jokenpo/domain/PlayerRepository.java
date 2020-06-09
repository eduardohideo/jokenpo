package com.jokenpo.jokenpo.domain;

import java.util.List;

public interface PlayerRepository {
    Player save(Player player);

    Player delete(String name);

    List<Player> getAll();

    Player update(Player player);

    Player get(String name);
}
