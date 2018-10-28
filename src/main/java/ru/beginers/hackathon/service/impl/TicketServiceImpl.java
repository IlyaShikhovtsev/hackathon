package ru.beginers.hackathon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.beginers.hackathon.AuthorizedUser;
import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.repository.SiteRepository;
import ru.beginers.hackathon.repository.TicketRepository;
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

    public boolean checkSite() {
        return true;
    }

    @Override
    public Ticket check(String siteName) {
        Ticket t = new Ticket();
        if (siteRepository.findByUserIdAndNameOrNameAndRoleId(AuthorizedUser.id(), siteName, siteName,
                userRepository.findUserById(AuthorizedUser.id()).getRole().getId()) == null) {
            t.setState(false);
        } else {
            t.setState(true);
        }
        return t;
    }

    @Override
    public boolean quantity(Ticket ticket) {
        if (siteRepository.findByIdAndRoleId(ticket.getUser().getId(),
                ticket.getUser().getRole().getId()).size() >= 5) {
            return true;
        }
        return false;
    }
}
