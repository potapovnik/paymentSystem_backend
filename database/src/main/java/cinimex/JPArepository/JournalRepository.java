package cinimex.JPArepository;

import cinimex.entity.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<JournalEntity,Long> {
    public List<JournalEntity> findByTransferId(Long id);
}
