package ch.zli.TerminManager.controller;

import ch.zli.TerminManager.domain.Termin;
import ch.zli.TerminManager.service.TerminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Termine")
public class TerminController {

    private TerminService terminService;

    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Termin> getAllTermine() {
        return terminService.findAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Termin createTermin(@Valid @RequestBody Termin termin) {
        return terminService.createTermin(termin);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        terminService.deleteTerminById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Termin updateEntry(@Valid @RequestBody Termin termin, @PathVariable Long id) {
        return terminService.updateTermin(termin, id);
    }
}
