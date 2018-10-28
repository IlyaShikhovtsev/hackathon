package ru.beginers.hackathon.web.ticket;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.beginers.hackathon.model.Site;
import ru.beginers.hackathon.model.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    public void createOrUpdate(@RequestParam("description") String description,
                               @RequestParam("siteName") String siteName) {
        Ticket ticket = new Ticket(description, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), new Site(siteName));
        super.create(ticket);
    }
}