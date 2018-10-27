package ru.beginers.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

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

    @NotBlank
    @Column(name = "role")
    private Set<Role> role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ticket> tickets;

    public User() {
    }

    public User(String login, String password, Set<Role> role, List<Ticket> tickets) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.tickets = tickets;
    }

    public User(Integer id, String name, String login, String password, Set<Role> role, List<Ticket> tickets) {
        super(id, name);
        this.login = login;
        this.password = password;
        this.role = role;
        this.tickets = tickets;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}