package com.ahansondev.sportsstats.service.cfb;

import com.ahansondev.sportsstats.model.cfb.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    public Optional<Team> getTeamById(int id);

    public List<Team> getAllTeams();

    public Team saveTeam(Team team);

}
