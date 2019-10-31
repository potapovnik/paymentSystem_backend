package cinimex.JPArepository;

import cinimex.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<TransferEntity,Long> {
    public List<TransferEntity> findByToBalanceId(Long id);
    public List<TransferEntity> findByFromBalanceId(Long id);
}
