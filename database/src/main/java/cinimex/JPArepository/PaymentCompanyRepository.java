package cinimex.JPArepository;

import cinimex.entity.PaymentCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentCompanyRepository extends JpaRepository<PaymentCompanyEntity,Long> {
    public List<PaymentCompanyEntity> findByCompanyId(Long idCompany);
}
