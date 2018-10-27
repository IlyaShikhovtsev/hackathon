package ru.beginers.hackathon.model;

import java.util.List;
import java.util.Set;

public class User extends AbstractNamedEntity {

    private String login;

    private String password;

    private Set<Role> role;

    private List<Ticket> tickets;

}