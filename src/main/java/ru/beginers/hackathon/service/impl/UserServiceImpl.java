package ru.beginers.hackathon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beginers.hackathon.model.User;
import ru.beginers.hackathon.repository.UserRepository;
import ru.beginers.hackathon.service.UserService;
import ru.beginers.hackathon.util.exception.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId()).orElse(new User());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        userRepository.deleteById(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User getByLogin(String login) throws NotFoundException {
        return userRepository.findByLogin(login);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

}
