package com.ahansondev.sportsstats.model.cfb;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * The POJO Model for the Conference table.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Entity
@Table(name = "cfb_team_game")
public class TeamGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamGameId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "homeTeamId")
    private Team homeTeamId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "awayTeamId")
    private Team awayTeamId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "gameTypeId")
    private GameType gameTypeId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "seasonId")
    private Season seasonId;

    private int homeScore;

    private int awayScore;

    private String result;

    private boolean homeFlag;

    private double totalYards;

    private double rushingYards;

    private int rushingAttempts;

    private double passingYards;

    private int passingAttempts;

    private int passingCompletions;

    private double sacks;

    private int penalties;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getTeamGameId() {
        return teamGameId;
    }

    public void setTeamGameId(Long teamGameId) {
        this.teamGameId = teamGameId;
    }

    public Team getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Team homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Team getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Team awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public GameType getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(GameType gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public Season getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Season seasonId) {
        this.seasonId = seasonId;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isHomeFlag() {
        return homeFlag;
    }

    public void setHomeFlag(boolean homeFlag) {
        this.homeFlag = homeFlag;
    }

    public double getTotalYards() {
        return totalYards;
    }

    public void setTotalYards(double totalYards) {
        this.totalYards = totalYards;
    }

    public double getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(double rushingYards) {
        this.rushingYards = rushingYards;
    }

    public int getRushingAttempts() {
        return rushingAttempts;
    }

    public void setRushingAttempts(int rushingAttempts) {
        this.rushingAttempts = rushingAttempts;
    }

    public double getPassingYards() {
        return passingYards;
    }

    public void setPassingYards(double passingYards) {
        this.passingYards = passingYards;
    }

    public int getPassingAttempts() {
        return passingAttempts;
    }

    public void setPassingAttempts(int passingAttempts) {
        this.passingAttempts = passingAttempts;
    }

    public int getPassingCompletions() {
        return passingCompletions;
    }

    public void setPassingCompletions(int passingCompletions) {
        this.passingCompletions = passingCompletions;
    }

    public double getSacks() {
        return sacks;
    }

    public void setSacks(double sacks) {
        this.sacks = sacks;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void onPrePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

}