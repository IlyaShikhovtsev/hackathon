package ru.beginers.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name = "users")
@Entity
public class User extends AbstractNamedEntity {

    @NotBlank
    @Size(max = 100)
    @Column(name = "login")
    private String login;

    @NotBlank
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", unique = true, nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ticket> tickets;

    @Column(name = "enabled")
    private final boolean enabled = true;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getLogin(), u.getPassword(), u.getRole());
    }

    public User(Integer id, String name, String login, String password, Role role) {
        super(id, name);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}