package ch.zli.TerminManager.repositories;

        import ch.zli.TerminManager.domain.Rolle;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface RolleRepository extends JpaRepository<Rolle, Long> {
}
