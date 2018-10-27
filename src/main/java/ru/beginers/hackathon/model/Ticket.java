package ru.beginers.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractBaseEntity {

    @Column(name = "user")
    private User user;

    @Column(name = "site")
    private String site;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "state")
    private boolean state;

    public Ticket() {
    }

    public Ticket(User user, String site, String description, LocalDateTime dateTime, boolean status) {
        this.user = user;
        this.site = site;
        this.description = description;
        this.dateTime = dateTime;
        this.state = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(boolean status) {
        this.state = status;
    }

    public User getUser() {
        return user;
    }

    public String getSite() {
        return site;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isStatus() {
        return state;
    }
}
