package cinimex.JPArepository;

import cinimex.entity.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntity,Long> {
}
