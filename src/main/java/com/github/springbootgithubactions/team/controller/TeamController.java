package com.github.springbootgithubactions.team.controller;


import com.github.springbootgithubactions.team.domain.Team;
import com.github.springbootgithubactions.team.model.TeamRequestDto;
import com.github.springbootgithubactions.team.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/1/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("")
    public Team createTeam(@RequestBody TeamRequestDto teamRequestDto){
        return teamService.create(teamRequestDto);
    }

    @GetMapping("")
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/{teamID}")
    public Team getTeam(@PathVariable("teamID") int teamID){
        return teamService.getTeam(teamID);
    }

    @PutMapping("/{teamID}")
    public Team updateTeam(@PathVariable("teamID") int teamID,@RequestBody TeamRequestDto teamRequestDto){
        return teamService.updateTeam(teamID,teamRequestDto);
    }

    @DeleteMapping("/{teamID}")
    public void deleteTeam(@PathVariable("teamID") int teamID){
         teamService.deleteTeam(teamID);
    }
}
