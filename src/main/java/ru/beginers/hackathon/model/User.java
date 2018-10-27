package ru.beginers.hackathon.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

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

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ticket> tickets;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getLogin(), u.getPassword(), u.getRoles());
    }

    public User(Integer id, String name, String login, String password, Role role, Role... roles) {
        this(id, name, login, password, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String login, String password, Collection<Role> roles) {
        super(id, name);
        this.login = login;
        this.password = password;
        setRoles(roles);
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}