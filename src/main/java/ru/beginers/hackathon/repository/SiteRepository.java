package ru.beginers.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.beginers.hackathon.model.Site;

import java.util.List;

@Transactional(readOnly = true)
public interface SiteRepository extends JpaRepository<Site, Integer> {

    List<Site> findByNameAndUserIdOrNameAndRoleId(String name, Integer userId, String name2, Integer roleId);
    Site findByUserIdAndNameOrNameAndRoleId(Integer userId, String name, String name2, Integer roleId);
    List<Site> findByUserIdAndRoleId(Integer id, Integer roleId);

}
