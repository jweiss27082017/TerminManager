package ch.zli.TerminManager.service;

        import ch.zli.TerminManager.domain.Termin;
        import ch.zli.TerminManager.domain.User;
        import ch.zli.TerminManager.repositories.TerminRepository;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class TerminService {
    private TerminRepository terminRepository;

    public TerminService(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    public List<Termin> findAll() {
        return terminRepository.findAll();
    }

    public Optional<Termin> findTerminById(long id) {
        return terminRepository.findById(id);
    }

    public Termin createTermin(Termin termin) {
        return terminRepository.saveAndFlush(termin);
    }

    public void deleteTerminById(long id) {
        if (terminRepository.existsById(id)) {
            terminRepository.deleteById(id);
        }
    }

    public Termin updateTermin(Termin termin, Long id) {
        Termin updatedTermin;
        Optional<Termin> optionalUpdatedTermin = findTerminById(id);

        if (optionalUpdatedTermin.isPresent()) {
            updatedTermin = optionalUpdatedTermin.get();
            updatedTermin.setDatum(termin.getDatum());
            updatedTermin.setOrt(termin.getOrt());
            updatedTermin.setTitel(termin.getTitel());
        } else {
            updatedTermin = termin;
            updatedTermin.setId(id);
        }
        return terminRepository.saveAndFlush(updatedTermin);
    }
}