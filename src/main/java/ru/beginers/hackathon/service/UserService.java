package ru.beginers.hackathon.service;

import ru.beginers.hackathon.model.User;
import ru.beginers.hackathon.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByLogin(String login) throws NotFoundException;

    void update(User user);

    List<User> getAll();
}
