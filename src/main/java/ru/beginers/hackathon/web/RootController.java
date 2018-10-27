package ru.beginers.hackathon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.beginers.hackathon.AuthorizedUser;
import ru.beginers.hackathon.service.TicketService;
import ru.beginers.hackathon.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        return "redirect:tickets";
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        model.addAttribute("tickets",
                ticketService.getAll(AuthorizedUser.id()));
        return "tickets";
    }
}