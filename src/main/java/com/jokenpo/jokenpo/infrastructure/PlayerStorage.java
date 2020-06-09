package com.jokenpo.jokenpo.infrastructure;

import com.jokenpo.jokenpo.domain.Player;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class PlayerStorage {

    private Map<String, Player> playerEntities;

    public PlayerStorage() {
        playerEntities = new ConcurrentHashMap<>();
    }

    public Player add(Player player) {
        playerEntities.put(player.getName(), player);
        return player;
    }

    public Player remove(String name) {
        return ofNullable(playerEntities.remove(name)).orElseThrow(NoSuchElementException::new);
    }

    public List<Player> getAll() {
        return playerEntities.values().stream().collect(Collectors.toList());
    }

    public Player get(String name) {
        return ofNullable(playerEntities.get(name)).orElseThrow(NoSuchElementException::new);
    }

    public Player update(Player player) {
        get(player.getName());
        playerEntities.replace(player.getName(), player);
        return player;
    }
}
