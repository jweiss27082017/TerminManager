package ch.zli.TerminManager.controller;

        import ch.zli.TerminManager.domain.Teilnahme;
        import ch.zli.TerminManager.service.TeilnahmeService;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.List;

@RestController
@RequestMapping("/Teilnahmen")
public class TeilnahmeController {

    private TeilnahmeService teilnahmeService;

    public TeilnahmeController(TeilnahmeService teilnahmeService) {
        this.teilnahmeService = teilnahmeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Teilnahme> getAllTeilnahmen() {
        return teilnahmeService.findAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Teilnahme createTeilnahme(@Valid @RequestBody Teilnahme teilnahme) {
        return teilnahmeService.createTeilnahme(teilnahme);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeilnahme(@PathVariable Long id) {
        teilnahmeService.deleteTeilnahmeById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Teilnahme updateTeilnahme(@Valid @RequestBody Teilnahme teilnahme, @PathVariable Long id) {
        return teilnahmeService.updateTeilnahme(teilnahme, id);
    }
}
