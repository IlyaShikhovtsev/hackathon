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

    @NotBlank
    @Size(max = 100)
    @Column(name = "site_id")
    private Integer siteId;

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
        this.siteId = siteId;
        this.description = description;
    }

    public Ticket(User user, Integer siteId, String description, LocalDateTime dateTime, boolean status) {
        this.user = user;
        this.siteId = siteId;
        this.description = description;
        this.dateTime = dateTime;
        this.state = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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

    public Integer getSiteId() {
        return siteId;
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
