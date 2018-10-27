package ru.beginers.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beginers.hackathon.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
