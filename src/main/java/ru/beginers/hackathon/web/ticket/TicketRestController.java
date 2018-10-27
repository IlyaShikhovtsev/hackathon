package ru.beginers.hackathon.web.ticket;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.beginers.hackathon.model.Ticket;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = TicketRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketRestController extends AbstractTicketController {
    static final String REST_URL = "/rest/profile/tickets";

    @Override
    @GetMapping("/{id}")
    public Ticket get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping
    public List<Ticket> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Ticket ticket, @PathVariable("id") int id) {
        super.update(ticket, id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createWithLocation(@RequestBody Ticket ticket) {
        Ticket created = super.create(ticket);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}