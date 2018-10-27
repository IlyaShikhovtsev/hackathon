package ru.beginers.hackathon.repository;

import ru.beginers.hackathon.model.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket Ticket, int userId);

    boolean delete(int id, int userId);

    Ticket get(int id, int userId);

    // ORDERED dateTime desc
    List<Ticket> getAll(int userId);

    Ticket getWithUser(int id, int userId);
}
