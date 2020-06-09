package com.jokenpo.jokenpo.domain.repository;

import com.jokenpo.jokenpo.domain.Player;
import com.jokenpo.jokenpo.domain.PlayerRepository;
import com.jokenpo.jokenpo.infrastructure.PlayerStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PlayerLocalRepository implements PlayerRepository {

    PlayerStorage playerStorage;

    @Autowired
    public PlayerLocalRepository(PlayerStorage playerStorage) {
        this.playerStorage = playerStorage;
    }

    @Override
    public Player save(Player player) {
        return playerStorage.add(player);
    }

    @Override
    public Player delete(String name) {
        return playerStorage.remove(name);
    }

    @Override
    public List<Player> getAll() {
        return playerStorage.getAll();
    }

    @Override
    public Player update(Player player) {
        return playerStorage.update(player);
    }

    @Override
    public Player get(String name) {
        return playerStorage.get(name);
    }

}
