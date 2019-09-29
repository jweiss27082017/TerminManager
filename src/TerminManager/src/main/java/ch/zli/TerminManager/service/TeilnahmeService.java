package ch.zli.TerminManager.service;

        import ch.zli.TerminManager.domain.Teilnahme;
        import ch.zli.TerminManager.repositories.TeilnahmeRepository;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class TeilnahmeService {
    private ch.zli.TerminManager.repositories.TeilnahmeRepository teilnahmeRepository;

    public TeilnahmeService(TeilnahmeRepository teilnahmeRepository) {
        this.teilnahmeRepository = teilnahmeRepository;
    }

    public List<Teilnahme> findAll() {
        return teilnahmeRepository.findAll();
    }

    public Optional<Teilnahme> findTeilnahmeById(long id) {
        return teilnahmeRepository.findById(id);
    }

    public Teilnahme createTeilnahme(Teilnahme teilnahme) {
        return teilnahmeRepository.saveAndFlush(teilnahme);
    }

    public void deleteTeilnahmeById(long id) {
        if (teilnahmeRepository.existsById(id)) {
            teilnahmeRepository.deleteById(id);
        }
    }

    public Teilnahme updateTeilnahme(Teilnahme teilnahme, Long id) {
        Teilnahme updatedTeilnahme;
        Optional<Teilnahme> optionalUpdatedTeilnahme = findTeilnahmeById(id);

        if (optionalUpdatedTeilnahme.isPresent()) {
            updatedTeilnahme = optionalUpdatedTeilnahme.get();
            updatedTeilnahme.setStatus(teilnahme.getStatus());
            updatedTeilnahme.setTermin(teilnahme.getTermin());
            updatedTeilnahme.setUser(teilnahme.getUser());
        } else {
            updatedTeilnahme = teilnahme;
            updatedTeilnahme.setId(id);
        }
        return teilnahmeRepository.saveAndFlush(updatedTeilnahme);
    }
}