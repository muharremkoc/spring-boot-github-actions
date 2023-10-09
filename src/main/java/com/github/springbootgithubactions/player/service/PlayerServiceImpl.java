package com.github.springbootgithubactions.player.service;


import com.github.springbootgithubactions.player.domain.Player;
import com.github.springbootgithubactions.player.model.PlayerRequestDto;
import com.github.springbootgithubactions.player.repository.PlayerRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

     final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player create(PlayerRequestDto playerRequestDto) {
        Player player = new Player();
        player.setPlayerName(playerRequestDto.getPlayerName());
        player.setUniformNumber(playerRequestDto.getUniformNumber());
        return playerRepository.save(player);
    }

    @Override
    public List<Player> players() {
        return playerRepository.findAll();
    }

    @Override
    public Player updatePlayer(int id, PlayerRequestDto playerRequestDto) {
        Player player = playerRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Player was not founded with %s",id)));
        player.setPlayerName(playerRequestDto.getPlayerName());
        player.setUniformNumber(playerRequestDto.getUniformNumber());
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayer(int id) {
        Player player = playerRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Player was not founded with %s",id)));

        return player;
    }
}
