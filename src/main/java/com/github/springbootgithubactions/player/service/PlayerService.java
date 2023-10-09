package com.github.springbootgithubactions.player.service;


import com.github.springbootgithubactions.player.domain.Player;
import com.github.springbootgithubactions.player.model.PlayerRequestDto;

import java.util.List;

public interface PlayerService {

    Player create(PlayerRequestDto playerRequestDto);

    List<Player> players();

    Player updatePlayer(int id,PlayerRequestDto playerRequestDto);

    Player getPlayer(int id);


}
