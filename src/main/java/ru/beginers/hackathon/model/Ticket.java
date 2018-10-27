package ru.beginers.hackathon.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractBaseEntity {

    private User user;

    private String site;

    private String description;

    private LocalDate date;

    private boolean status;

    public Ticket() {
    }

    public Ticket(User user, String site, String description, LocalDate date, boolean status) {
        this.user = user;
        this.site = site;
        this.description = description;
        this.date = date;
        this.status = status;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public LocalDate getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }
}
