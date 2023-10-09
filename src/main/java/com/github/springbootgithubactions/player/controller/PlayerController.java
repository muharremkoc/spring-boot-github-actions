package com.github.springbootgithubactions.player.controller;


import com.github.springbootgithubactions.player.domain.Player;
import com.github.springbootgithubactions.player.model.PlayerRequestDto;
import com.github.springbootgithubactions.player.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/1/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("")
    public Player createPlayer(@RequestBody PlayerRequestDto playerRequestDto){
        return playerService.create(playerRequestDto);
    }

    @GetMapping("")
    public List<Player> players(){
        return playerService.players();
    }

    @PutMapping("/{playerID}")
    public Player updatePlayer(@PathVariable("playerID") int playerID,@RequestBody PlayerRequestDto playerRequestDto){
        return playerService.updatePlayer(playerID, playerRequestDto);
    }

    @GetMapping("/{playerID}")
    public Player getPlayer(@PathVariable("playerID") int playerID){
        return playerService.getPlayer(playerID);
    }
}
