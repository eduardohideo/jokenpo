package com.jokenpo.jokenpo.application.facade;

import com.jokenpo.jokenpo.application.PlayerDTO;
import com.jokenpo.jokenpo.application.PlayerFacade;
import com.jokenpo.jokenpo.application.exception.PlayerNotFoundException;
import com.jokenpo.jokenpo.domain.Player;
import com.jokenpo.jokenpo.domain.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class PlayerFacadeImpl implements PlayerFacade {
    @Autowired
    PlayerRepository repository;

    public PlayerFacadeImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlayerDTO insertPlayer(String name) {
        return PlayerDTO.toDTO(repository.save(new Player.Builder().withName(name).build()));
    }

    @Override
    public PlayerDTO deletePlayer(String name) {
        try {
            return PlayerDTO.toDTO(repository.delete(name));
        } catch (NoSuchElementException e) {
            throw new PlayerNotFoundException("Nome nao cadastrado");
        }
    }

    @Override
    public PlayerDTO insertJokenMove(PlayerDTO playerDTO) {
        try {
            return PlayerDTO.toDTO(repository.update(PlayerDTO.toEntity(playerDTO)));
        } catch (NoSuchElementException e) {
            throw new PlayerNotFoundException("Nome nao cadastrado");
        }
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return repository.getAll().stream().map(player -> PlayerDTO.toDTO(player)).collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getPlayer(String name) {
        try {
            return PlayerDTO.toDTO(repository.get(name));
        } catch (NoSuchElementException e) {
            throw new PlayerNotFoundException("Nome nao cadastrado");
        }
    }
}
