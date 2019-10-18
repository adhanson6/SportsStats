package com.ahansondev.sportsstats.model.cfb;

import com.ahansondev.sportsstats.enums.cfb.GameTypes;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * The POJO Model for the Season table.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Entity
@Table(name = "cfb_game_type")
public class GameType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameTypeId;

    @Enumerated(EnumType.STRING)
    private GameTypes gameType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Long gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public GameTypes getGameType() {
        return gameType;
    }

    public void setGameType(GameTypes gameType) {
        this.gameType = gameType;
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
