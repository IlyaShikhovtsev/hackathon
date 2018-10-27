package ru.beginers.hackathon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.beginers.hackathon.AuthorizedUser;
import ru.beginers.hackathon.service.TicketService;
import ru.beginers.hackathon.service.UserService;

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String root() {
        return "redirect:tickets";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        model.addAttribute("tickets",
                ticketService.getAll(AuthorizedUser.id()));
        return "tickets";
    }
}