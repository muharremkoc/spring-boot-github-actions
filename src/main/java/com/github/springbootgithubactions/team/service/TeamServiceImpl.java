package com.github.springbootgithubactions.team.service;

import com.github.springbootgithubactions.team.domain.Team;
import com.github.springbootgithubactions.team.model.TeamRequestDto;
import com.github.springbootgithubactions.team.repository.TeamRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team create(TeamRequestDto teamRequestDto) {
        Team team =new Team();
        team.setTeamName(teamRequestDto.getTeamName());
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(int id, TeamRequestDto teamRequestDto) {
        Team team = teamRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Team was not founded with %s",id)));
         team.setTeamName(teamRequestDto.getTeamName());
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(int id) {
        Team team = teamRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Team was not founded with %s",id)));
        teamRepository.deleteById(team.getTeamID());
    }

    @Override
    public Team getTeam(int id) {
        Team team = teamRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Team was not founded with %s",id)));

        return team;
    }
}
