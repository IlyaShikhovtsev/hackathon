package ru.beginers.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beginers.hackathon.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
