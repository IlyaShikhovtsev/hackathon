package ru.beginers.hackathon.service;

import ru.beginers.hackathon.model.User;
import ru.beginers.hackathon.util.exception.NotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByLogin(String email) throws NotFoundException {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getWithMeals(int id) {
        return null;
    }
}
