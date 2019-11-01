package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "public", catalog = "payment_system")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", sequenceName = "company_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    @Column(name = "balance_id")
    private Long balanceId;
    @Column(name = "number_of_card")
    private Integer numberOfCard;

}
