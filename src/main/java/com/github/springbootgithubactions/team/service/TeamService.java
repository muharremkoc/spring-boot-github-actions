package com.github.springbootgithubactions.team.service;



import com.github.springbootgithubactions.team.domain.Team;
import com.github.springbootgithubactions.team.model.TeamRequestDto;

import java.util.List;

public interface TeamService {

    Team create(TeamRequestDto teamRequestDto);

    List<Team> getTeams();

    Team updateTeam(int id,TeamRequestDto teamRequestDto);

    void  deleteTeam(int id);

    Team getTeam(int id);
}
