package ru.beginers.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "user_roles")
@Entity
public class Role {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "roles_name")
    private String rolesName;

}