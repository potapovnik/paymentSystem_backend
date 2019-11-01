package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payment_company", schema = "public", catalog = "payment_system")
@Data
public class PaymentCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_company_seq")
    @SequenceGenerator(name = "payment_company_seq", sequenceName = "payment_company_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private Integer amount;
    @Column(name = "company_id")
    private Long companyId;

}
