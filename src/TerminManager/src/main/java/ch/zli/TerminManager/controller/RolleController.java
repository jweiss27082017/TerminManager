package ch.zli.TerminManager.controller;

import java.util.List;

import ch.zli.TerminManager.service.RolleService;
import ch.zli.TerminManager.domain.Rolle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Rolle")
public class RolleController {

    private RolleService rolleService;

    public RolleController(RolleService rolleService) {
        this.rolleService = rolleService;
    }

    //Hier werden alle Rollen zurückgegeben
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Rolle> getAllRolle() {
        return rolleService.findAll();
    }

    //Hier wird eine neue Rolle generiert
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Rolle createRolle(@Valid @RequestBody Rolle rolle) {
        return rolleService.createRolle(rolle);
    }

    //Hier wird eine vorhandene Rolle gelöscht
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRolle(@PathVariable Long id) {
        rolleService.deleteRolleById(id);
    }

    //Hier wird eine bestimmte Rolle mutiert
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rolle updateRolle(@Valid @RequestBody Rolle rolle, @PathVariable Long id) {
        return rolleService.updateRolle(rolle, id);
    }
}
