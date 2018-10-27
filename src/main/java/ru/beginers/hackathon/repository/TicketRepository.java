package ru.beginers.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beginers.hackathon.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
