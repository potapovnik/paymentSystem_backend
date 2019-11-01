package cinimex.JPArepository;

import cinimex.entity.PaymentUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentUserRepository  extends JpaRepository<PaymentUserEntity,Long> {
}
