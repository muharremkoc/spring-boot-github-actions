package com.github.springbootgithubactions.player.model;

public class PlayerRequestDto {

    private String playerName;

    private  int uniformNumber;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(int uniformNumber) {
        this.uniformNumber = uniformNumber;
    }
}
