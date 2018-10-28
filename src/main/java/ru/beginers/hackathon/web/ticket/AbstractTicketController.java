package ru.beginers.hackathon.web.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.beginers.hackathon.AuthorizedUser;
import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.repository.SiteRepository;
import ru.beginers.hackathon.repository.impl.CrudUserRepository;
import ru.beginers.hackathon.service.TicketService;

import java.util.List;

import static ru.beginers.hackathon.util.ValidationUtil.assureIdConsistent;
import static ru.beginers.hackathon.util.ValidationUtil.checkNew;

public abstract class AbstractTicketController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TicketService service;
    @Autowired
    private CrudUserRepository userRepository;
    @Autowired
    private SiteRepository siteRepository;

    public Ticket get(int id) {
        int userId = AuthorizedUser.id();
        log.info("get ticket {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        log.info("delete ticket {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<Ticket> getAll() {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        return service.getAll(userId);
    }

    public Ticket create(Ticket ticket) {
        int userId = AuthorizedUser.id();
        checkNew(ticket);
        log.info("create {} for user {}", ticket, userId);
        return service.create(ticket, userId);
    }

    public void update(Ticket ticket, int id) {
        int userId = AuthorizedUser.id();
        assureIdConsistent(ticket, id);
        log.info("update {} for user {}", ticket, userId);
        service.update(ticket, userId);
    }

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

    public boolean quantity(Ticket ticket) {
        if (siteRepository.findByIdAndRoleId(ticket.getUser().getId(),
                ticket.getUser().getRole().getId()).size() >= 5) {
            return true;
        }
        return false;
    }
}