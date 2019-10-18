package com.ahansondev.sportsstats.service.cfb.impl;

import com.ahansondev.sportsstats.model.cfb.Team;
import com.ahansondev.sportsstats.repository.cfb.TeamRepository;
import com.ahansondev.sportsstats.service.cfb.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Optional<Team> getTeamById(int id) {
        return teamRepository.findById((long) id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

}
