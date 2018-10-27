package ru.beginers.hackathon.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @NotBlank
    @Size(max = 100)
    @Column(name = "site")
    private String site;

    @NotBlank
    @Size(max = 100)
    @Column(name = "description")
    private String description;

    @NotBlank
    @Size(max = 100)
    @Column(name = "date")
    private LocalDateTime dateTime;

    @NotBlank
    @Size(max = 100)
    @Column(name = "state")
    private boolean state;

    public Ticket() {
    }

    public Ticket(String site, String description) {
        this.site = site;
        this.description = description;
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
