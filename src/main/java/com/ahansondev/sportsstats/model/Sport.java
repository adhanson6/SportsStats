package com.ahansondev.sportsstats.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * The POJO Model for the Sport table.
 * @version 0.0.1
 * @author Alex Hanson
 */
@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @Column(name = "sportId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sportId;

    @NotBlank
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    private Sport() {}

    public Sport(String name) {
        this.name = name;
    }

    private Sport(Long sportId, String name, Date createdAt, Date updatedAt) {
        this.sportId = sportId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return sportId;
    }

    public void setId(Long sportId) {
        this.sportId = sportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
