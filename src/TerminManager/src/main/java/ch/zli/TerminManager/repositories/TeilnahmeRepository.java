package ch.zli.TerminManager.repositories;

        import ch.zli.TerminManager.domain.Rolle;
        import ch.zli.TerminManager.domain.Teilnahme;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface TeilnahmeRepository extends JpaRepository<Teilnahme, Long> {
}


