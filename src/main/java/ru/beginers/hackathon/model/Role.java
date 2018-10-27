package ru.beginers.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "user_roles")
@Entity
public class Role extends AbstractBaseEntity{

    @NotBlank
    @Size(max = 100)
    @Column(name = "roles_name")
    private String rolesName;

}