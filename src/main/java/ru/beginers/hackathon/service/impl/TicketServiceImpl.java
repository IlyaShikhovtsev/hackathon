package ru.beginers.hackathon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.repository.TicketRepository;
import ru.beginers.hackathon.service.TicketService;
import ru.beginers.hackathon.util.exception.NotFoundException;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket get(int id, int userId) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {

    }

    @Override
    public List<Ticket> getAll(int userId) {
        return null;
    }

    @Override
    public Ticket update(Ticket ticket, int userId) throws NotFoundException {
        return null;
    }

    @Override
    public Ticket create(Ticket ticket, int userId) {
        return null;
    }

    @Override
    public Ticket getWithUser(int id, int userId) {
        return null;
    }
}