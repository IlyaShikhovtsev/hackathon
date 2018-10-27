package ru.beginers.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "sites")
@Entity
public class Site extends AbstractBaseEntity{
    @NotBlank
    @Size(max = 100)
    @Column(name = "domain_name")
    private String domainName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank
    @Size(max = 100)
    @Column(name = "role_id")
    private Integer roleId;

    public Site() {
    }

    public Site(@NotBlank @Size(max = 100) String domainName, @NotBlank @Size(max = 100) Integer userId, @NotBlank @Size(max = 100) Integer roleId) {
        this.domainName = domainName;
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
