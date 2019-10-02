package ch.zli.TerminManager.controller;

import java.util.List;

import ch.zli.TerminManager.service.UserService;
import ch.zli.TerminManager.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Hier werden alle User zurückgegeben
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    //Hier wird ein neuer User generiert
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    //Hier wird ein vorhandener User gelöscht
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    //Hier wird ein bestimmter User mutiert
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateEntry(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateEntry(user, id);
    }
}
