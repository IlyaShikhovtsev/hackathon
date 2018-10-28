package ru.beginers.hackathon.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.beginers.hackathon.model.Site;
import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.repository.TicketRepository;

import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private CrudTicketRepository crudTicketRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public Ticket save(Ticket ticket, int userId) {
        if (!ticket.isNew() && get(ticket.getId(), userId) == null) {
            return null;
        }
        ticket.setUser(crudUserRepository.getOne(userId));
        ticket.setSite(new Site(ticket.getSite().getName(), userId, null));
        return crudTicketRepository.save(ticket);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudTicketRepository.delete(id, userId) != 0 ;
    }

    @Override
    public Ticket get(int id, int userId) {
        return crudTicketRepository.findById(id).filter(ticket -> ticket.getUser().getId() == userId).orElse(null);
    }

    @Override
    public List<Ticket> getAll(int userId) {
        if(crudUserRepository.findUserById(userId).getRole().getName().equals("Admin")) {
            return crudTicketRepository.findAll();
        }
        return  crudTicketRepository.getAllByUserId(userId);
    }

    @Override
    public Ticket getWithUser(int id, int userId) {
        return crudTicketRepository.getWithUser(id,userId);
    }


}
