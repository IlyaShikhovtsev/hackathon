package ru.beginers.hackathon;

import ru.beginers.hackathon.model.AbstractBaseEntity;

public class AuthorizedUser {
    private static int id = AbstractBaseEntity.START_SEQ + 2;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}