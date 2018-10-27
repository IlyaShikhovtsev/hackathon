package ru.beginers.hackathon.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="site_id", unique = true, nullable = false)
    private Site site;

    @NotBlank
    @Size(max = 100)
    @Column(name = "description")
    private String description;

    @NotBlank
    @Size(max = 100)
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @NotBlank
    @Size(max = 100)
    @Column(name = "state")
    private boolean state;

    public Ticket() {
    }

    public Ticket(Integer siteId, String description) {
        this.description = description;
    }

    public Ticket(User user, String description, LocalDateTime dateTime, boolean status) {
        this.user = user;
        this.description = description;
        this.dateTime = dateTime;
        this.state = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
