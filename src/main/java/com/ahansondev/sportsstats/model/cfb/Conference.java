package com.ahansondev.sportsstats.model.cfb;

import com.ahansondev.sportsstats.model.Sport;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * The POJO Model for the Conference table.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Entity
@Table(name = "cfb_conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long conferenceId;

    @NotBlank
    private String name;

    private String division;

    @ManyToOne
    @JoinColumn(name = "sportId")
    private Sport sportId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    private Conference() {}

    public Conference(String name, String division) {
        this.name = name;
        this.division = division;
    }

    private Conference(Long conferenceId, String name, String division, Date createdAt, Date updatedAt) {
        this.conferenceId = conferenceId;
        this.name = name;
        this.division = division;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Long conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
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

    public Sport getSportId() {
        return sportId;
    }

    public void setSportId(Sport sportId) {
        this.sportId = sportId;
    }

    @PrePersist
    public void onPrePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

}
