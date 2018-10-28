package ru.beginers.hackathon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.beginers.hackathon.AuthorizedUser;
import ru.beginers.hackathon.model.Site;
import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.repository.SiteRepository;
import ru.beginers.hackathon.repository.TicketRepository;
import ru.beginers.hackathon.repository.impl.CrudTicketRepository;
import ru.beginers.hackathon.repository.impl.CrudUserRepository;
import ru.beginers.hackathon.service.TicketService;
import ru.beginers.hackathon.util.exception.NotFoundException;

import java.util.List;

import static ru.beginers.hackathon.util.ValidationUtil.checkNotFoundWithId;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private CrudUserRepository userRepository;
    @Autowired
    private CrudTicketRepository ticketRepository;

    @Override
    public Ticket get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public List<Ticket> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Ticket update(Ticket ticket, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.save(ticket, userId), ticket.getId());
    }

    @Override
    public Ticket create(Ticket ticket, int userId) {
        Assert.notNull(ticket, "ticket must not be null");

        if (siteRepository.findByNameAndUserIdOrNameAndRoleId(
                ticket.getSite().getName(), userId, ticket.getSite().getName(), userRepository.findUserById(userId).getRole().getId())
                .size() != 0) {
            ticket.setState(true);
            return ticket;
        }
        return repository.save(ticket, userId);
    }

    @Override
    public Ticket getWithUser(int id, int userId) {
        return checkNotFoundWithId(repository.getWithUser(id, userId), id);
    }

    @Override
    public Ticket check(String siteName, int userId) {
        Ticket t = new Ticket();
        if (siteRepository.findByUserIdAndNameOrNameAndRoleId(AuthorizedUser.id(), siteName, siteName,
                userRepository.findUserById(AuthorizedUser.id()).getRole().getId()).size() != 0) {
            t.setState(true);
        } else if (siteRepository.findByUserIdAndRoleId(userId,
                userRepository.findUserById(userId).getRole().getId()).size() >= 5) {
            t.setState(true);
        } else {
            t.setState(false);
        }

        return t;
    }

    public void acceptTicket(int id, int userId) {
        siteRepository.save(new Site(ticketRepository.findById(id).get().getSite().getName(), userId,
                userRepository.findUserById(userId).getRole().getId()));
        ticketRepository.deleteById(id);
    }
}
