package ru.beginers.hackathon.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.beginers.hackathon.model.User;

import java.util.List;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    /*@PostMapping
    public void createOrUpdate(@RequestParam("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password) {

        User user = new User(id, name, login, password, Role.ROLE_USER);
        if (user.isNew()) {
            super.create(user);
        }
    }*/
}
