package cinimex.JPArepository;

import cinimex.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {
    public BalanceEntity findByUserId( Long user_id);
    public BalanceEntity findByNumberOfBalance(String balanceNumber);
}
