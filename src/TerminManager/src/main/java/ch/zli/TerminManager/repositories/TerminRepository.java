package ch.zli.TerminManager.repositories;

        import ch.zli.TerminManager.domain.Termin;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {
}
