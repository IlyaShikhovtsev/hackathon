package ru.beginers.hackathon.web.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.beginers.hackathon.model.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


@Controller
@RequestMapping(value = "/tickets")
public class JspTicketController extends AbstractTicketController {

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/tickets";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("ticket", super.get(getId(request)));
        return "ticketForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticketForm";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Ticket ticket = new Ticket(request.getParameter("site"), request.getParameter("description"));

        if (request.getParameter("id").isEmpty()) {
            super.create(ticket);
        } else {
            super.update(ticket, getId(request));
        }
        return "redirect:/tickets";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
