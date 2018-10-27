package ru.beginers.hackathon.service;

import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.util.exception.NotFoundException;

import java.util.List;

public interface TicketService {
    Ticket get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    List<Ticket> getAll(int userId);

    Ticket update(Ticket ticket, int userId) throws NotFoundException;

    Ticket create(Ticket ticket, int userId);

    Ticket getWithUser(int id, int userId);
}
