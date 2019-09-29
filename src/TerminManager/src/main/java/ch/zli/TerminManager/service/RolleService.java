package ch.zli.TerminManager.service;

import ch.zli.TerminManager.domain.Rolle;
import ch.zli.TerminManager.repositories.RolleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolleService {
    private RolleRepository rolleRepository;

    public RolleService(RolleRepository rolleRepository) {
        this.rolleRepository = rolleRepository;
    }

    public List<Rolle> findAll() {
        return rolleRepository.findAll();
    }

    public Optional<Rolle> findRolleById(long id) {
        return rolleRepository.findById(id);
    }

    public Rolle createRolle(Rolle rolle) {
        return rolleRepository.saveAndFlush(rolle);
    }

    public void deleteRolleById(long id) {
        if (rolleRepository.existsById(id)) {
            rolleRepository.deleteById(id);
        }
    }

    public Rolle updateRolle(Rolle rolle, Long id) {
        Rolle updatedRolle;
        Optional<Rolle> optionalUpdatedRolle = findRolleById(id);

        if (optionalUpdatedRolle.isPresent()) {
            updatedRolle = optionalUpdatedRolle.get();
            updatedRolle.setBezeichnung(rolle.getBezeichnung());
        } else {
            updatedRolle = rolle;
            updatedRolle.setId(id);
        }
        return rolleRepository.saveAndFlush(updatedRolle);
    }
}