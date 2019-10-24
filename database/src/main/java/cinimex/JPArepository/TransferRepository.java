package cinimex.JPArepository;

import cinimex.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferEntity,Long> {
}
