package cinimex.JPArepository;

import cinimex.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<BalanceEntity,Long> {
}
