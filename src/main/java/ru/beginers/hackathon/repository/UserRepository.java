package ru.beginers.hackathon.repository;

import ru.beginers.hackathon.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByLogin(String login);

    List<User> getAll();

    User getWithTickets(int id);
}
