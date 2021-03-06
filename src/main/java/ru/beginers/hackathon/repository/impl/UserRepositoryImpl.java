package ru.beginers.hackathon.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.beginers.hackathon.model.User;
import ru.beginers.hackathon.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudUserRepository.delete(id)!=0;
    }

    @Override
    public User get(int id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    @Override
    public User getByLogin(String login) {
        return crudUserRepository.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll();
    }

    @Override
    public User getWithTickets(int id) {
        return crudUserRepository.getWithTickets(id);
    }
}