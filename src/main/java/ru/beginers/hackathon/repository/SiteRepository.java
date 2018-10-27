package ru.beginers.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beginers.hackathon.model.Site;

public interface SiteRepository extends JpaRepository<Site, Integer> {
}
