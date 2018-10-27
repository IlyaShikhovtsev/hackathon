package ru.beginers.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
public class Role extends AbstractNamedEntity {
}