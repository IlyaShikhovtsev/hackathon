package ru.beginers.hackathon.model;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public abstract class AbstractBaseEntity implements Persistable<Integer> {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    protected Integer id;

    protected AbstractBaseEntity() {
    }

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}