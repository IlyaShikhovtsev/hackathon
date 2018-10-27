package ru.beginers.hackathon.web.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.beginers.hackathon.model.Ticket;
import ru.beginers.hackathon.util.ValidationUtil;

import javax.validation.Valid;
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
    public ResponseEntity<String> createOrUpdate(@Valid Ticket ticket, BindingResult result) {
        if (result.hasErrors()) {
            return ValidationUtil.getErrorResponse(result);
        }
        if (ticket.isNew()) {
            super.create(ticket);
        } else {
            super.update(ticket, ticket.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}