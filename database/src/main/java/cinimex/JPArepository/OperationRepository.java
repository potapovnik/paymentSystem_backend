package cinimex.JPArepository;

import cinimex.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationEntity,Long> {
}
