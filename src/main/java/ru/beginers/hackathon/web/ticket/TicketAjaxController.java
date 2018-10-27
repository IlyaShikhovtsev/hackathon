package ru.beginers.hackathon.web.ticket;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.beginers.hackathon.model.Ticket;

import java.util.List;

@RestController
@RequestMapping(value = "/ajax/profile/ticket")
public class TicketAjaxController extends AbstractTicketController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ticket> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@RequestParam("id") Integer id,
                               @RequestParam("description") String description,
                               @RequestParam("site") String site) {
        Ticket ticket = new Ticket();
        if (ticket.isNew()) {
            super.create(ticket);
        }
    }
}